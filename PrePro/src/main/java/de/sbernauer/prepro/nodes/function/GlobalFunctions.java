package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.variables.Constant;
import de.sbernauer.prepro.variables.Variable;
import org.nd4j.linalg.factory.Nd4j;

import java.util.function.BiFunction;

public abstract class GlobalFunctions {

    public static void registerGlobalFunctions(FunctionTable functionTable) {


        // Returns first value
        functionTable.addFunction(createFunction("testGlobalFunctionReturnFirstArgument", (arguments, ft) -> {
            return arguments.getValues()[0];
        }));


        //Returns second value
        functionTable.addFunction(createFunction("testGlobalFunctionReturnSecondArgument", (arguments, ft) -> {
            return arguments.getValues()[1];
        }));


        //Returns amount of time-elements for a given variable (must not be constant)
        functionTable.addFunction(createFunction("amountTimeElements", (arguments, ft) -> {
            if(arguments.getValues().length != 1 || arguments.getValues()[0] instanceof Constant) {
                throw new RuntimeException("The function amountTimeElements must be called with one argument (not a constant).");
            }
            return new Constant(Nd4j.create(new double[]{arguments.getValues()[0].getAmountTimeElements()}, new int[]{1, 1}));
        }));


    }

    private static Function createFunction(String functionName, BiFunction<Arguments, FunctionTable, Variable> function) {
        return new Function() {
            @Override
            public String getFunctionName() {
                return functionName;
            }

            @Override
            public Variable execute(Arguments arguments, FunctionTable functionTable) {
                return function.apply(arguments, functionTable);
            }
        };
    }
}
