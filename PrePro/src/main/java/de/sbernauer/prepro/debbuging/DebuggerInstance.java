package de.sbernauer.prepro.debbuging;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.PreProNode;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import de.sbernauer.prepro.nodes.statement.StatementNode;
import de.sbernauer.prepro.parser.PreProLexer;
import de.sbernauer.prepro.parser.PreProParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;

import java.io.InputStreamReader;
import java.util.Scanner;

public class DebuggerInstance implements Debugger {
    private static final Scanner SCANNER = new Scanner(new InputStreamReader(System.in));

    private static DebuggerInstance instance;


    private DebuggerInstance() {

    }

    public static DebuggerInstance getInstance() {
        if (instance == null) {
            instance = new DebuggerInstance();
        }
        return instance;
    }

    private static String evaluateExpression(String expression, SymbolTable symbolTable, FunctionTable functionTable) {

        try {
            PreProLexer lexer = new PreProLexer(CharStreams.fromString(expression));
            PreProParser parser = new PreProParser(new CommonTokenStream(lexer));
            parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
            PreProNode evalNode = parser.statement().result;
            if (evalNode != null) {
                ((StatementNode) evalNode).execute(symbolTable, functionTable);
                return "Executed";
            } else {
                lexer.reset();
                evalNode = new PreProParser(new CommonTokenStream(lexer)).expression().result;
                return ((ExpressionNode) evalNode).execute(symbolTable, functionTable).toString();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public void wait(SymbolTable symbolTable, FunctionTable functionTable, int lineNumber) {
        while (true) {
            System.out.print("(" + lineNumber + ")> ");

            String input = SCANNER.nextLine();
            switch (input) {
                case "exit":
                    System.exit(0);
                    break;
                case "step":
                    return;
                case "vars":
                    System.out.println(symbolTable);
                    break;
                default:
                    if (input.startsWith("eval")) {
                        System.out.println(evaluateExpression(input.substring(5), symbolTable, functionTable));
                    } else {
                        System.out.println("Error: Command \"" + input + "\" not found.");
                    }
                    break;
            }
        }
    }
}
