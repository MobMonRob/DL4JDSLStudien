package nodes.statement;

import nodes.FunctionTable;
import nodes.SymbolTable;

import java.util.Arrays;

public class StatementListNode extends StatementNode {
    @Children
    private StatementNode[] statementNodes;

    private int executionCount = 0;

    public StatementListNode(StatementNode[] statementNodes) {
        this.statementNodes = statementNodes;
    }

    @Override
    public void execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Arrays.stream(statementNodes).forEach(statementNode -> statementNode.execute(symbolTable, functionTable));
    }

    public boolean executeNext(SymbolTable symbolTable, FunctionTable functionTable) {
        statementNodes[executionCount].execute(symbolTable, functionTable);
        executionCount++;
        return executionCount < statementNodes.length;
    }

    public int getLineNumber() {
        return statementNodes[executionCount].getLineNumber();
    }
}
