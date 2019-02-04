package de.sbernauer.prepro.nodes;

import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.function.CustomFunctionNode;
import de.sbernauer.prepro.nodes.function.FunctionNode;
import de.sbernauer.prepro.nodes.function.MainFunctionNode;

public class MainNode implements PreProNode {
    private final FunctionTable functionTable = new FunctionTable();

    public MainNode(FunctionNode[] functionNodes) {
        Arrays.stream(functionNodes).forEach(
                functionTable::addFunction
        );
    }

    public PreProDataSet execute(PreProDataSet preProDataSet) {
        MainFunctionNode mainFunctionNode = (MainFunctionNode) functionTable.getFunction("main");

        return mainFunctionNode.executeMainFunction(preProDataSet, functionTable);
    }

    public void registerFunction(Class clazz, String functionName) {
        functionTable.addFunction(new CustomFunctionNode(clazz, functionName));
    }
}
