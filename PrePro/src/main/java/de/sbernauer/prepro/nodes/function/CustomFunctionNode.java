package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.variables.Variable;
import de.sbernauer.prepro.variables.Vector3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomFunctionNode implements Function {
    private final String functionName;
    private final Class[] parameterTypes;
    private final Class returnType;

    private final Method function;

    public CustomFunctionNode(Class clazz, String functionName) {
        long countFunctions = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().equals(functionName))
                .count();

        if (countFunctions == 0) {
            throw new RuntimeException("No function \"" + functionName + "\" defined.");
        } else if (countFunctions > 1) {
            throw new RuntimeException("Multiple definitons of the function \"" + functionName + "\" found." +
                    "Please rename the functions to have different names.");
        }

        this.function = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().equals(functionName))
                .findAny()
                .get();
        this.functionName = functionName;
        this.parameterTypes = function.getParameterTypes();
        this.returnType = function.getReturnType() == Void.TYPE ? null : function.getReturnType();

        for (Class parameterType : parameterTypes) {
            if (!Variable.class.isAssignableFrom(parameterType)) {
                throw new RuntimeException("A parameter of the custom function " + functionName
                        + " has the type " + parameterType + ". The type must be a type of variable known by PrePro.");
            }
        }
    }

    @Override
    public String getFunctionName() {
        return functionName;
    }

    /**
     * @return null, if the function is void
     */
    @Override
    public Variable execute(Arguments arguments, FunctionTable functionTable) {
        if (parameterTypes.length != arguments.getValues().length) {
            throw new RuntimeException("Number of Argument for the custom function \"" + functionName + "\" differs.");
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            if (arguments.getValues()[i].getClass() != parameterTypes[i]) {
                throw new RuntimeException("Wrong type for the #" + (i + 1) + " parameter " +
                        "for custom function " + functionName + ". "
                        + "Was " + arguments.getValues()[i].getClass().getSimpleName()
                        + " but must be " + parameterTypes[i].getSimpleName());
            }
        }

        try {
            this.function.setAccessible(true);
            // Invoking on null, because the given custom functions are static
            Object result = this.function.invoke(null, arguments.getValues());
            if (result == null) { // Void function
                return null;
            }
            if (result.getClass() != returnType) {
                throw new RuntimeException("The custom function " + functionName + " must return the Type " + returnType
                        + "but has returned " + result.getClass().getSimpleName());
            }
            return (Variable) result;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
