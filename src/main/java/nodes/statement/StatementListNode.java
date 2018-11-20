package nodes.statement;

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
    public void execute(SymbolTable symbolTable) {
        Arrays.stream(statementNodes).forEach(statementNode -> statementNode.execute(symbolTable));
    }

    public boolean executeNext(SymbolTable symbolTable) {
        statementNodes[executionCount].execute(symbolTable);
        executionCount++;
        return executionCount < statementNodes.length;
    }

    public int getLineNumber() {
        return statementNodes[executionCount].getLineNumber();
    }
}
