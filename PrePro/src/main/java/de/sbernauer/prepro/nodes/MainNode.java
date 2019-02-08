package de.sbernauer.prepro.nodes;

import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.function.CustomFunctionNode;
import de.sbernauer.prepro.nodes.function.FunctionNode;
import de.sbernauer.prepro.nodes.function.GlobalFunctions;
import de.sbernauer.prepro.nodes.function.MainFunctionNode;

public class MainNode implements PreProNode {
    private final FunctionTable functionTable = new FunctionTable();

    public MainNode(FunctionNode[] functionNodes) {
        GlobalFunctions.registerGlobalFunctions(functionTable);
        for (FunctionNode function : functionNodes) {
            functionTable.addFunction(function, false);
        }
    }

    public PreProDataSet execute(PreProDataSet preProDataSet, SymbolTable symbolTable) {
        MainFunctionNode mainFunctionNode = (MainFunctionNode) functionTable.getFunction("main");

        return mainFunctionNode.executeMainFunction(preProDataSet, functionTable, symbolTable);
    }

    public void registerFunction(Class clazz, String functionName) {
        functionTable.addFunction(new CustomFunctionNode(clazz, functionName));
    }
}
