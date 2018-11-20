package debbuging;

import com.oracle.truffle.api.nodes.Node;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import nodes.statement.StatementNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import parser.PreProLexer;
import parser.PreProParser;

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

    @Override
    public void wait(SymbolTable symbolTable, int lineNumber) {
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
                        System.out.println(evaluateExpression(input.substring(5), symbolTable));
                    } else {
                        System.out.println("Error: Command \"" + input + "\" not found.");
                    }
                    break;
            }
        }
    }

        private static String evaluateExpression(String expression, SymbolTable symbolTable) {

            try {
                PreProLexer lexer = new PreProLexer(CharStreams.fromString(expression));
                PreProParser parser = new PreProParser(new CommonTokenStream(lexer));
                parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
                Node evalNode = parser.statement().result;
                if (evalNode != null) {
                    ((StatementNode) evalNode).execute(symbolTable);
                    return "Executed";
                } else {
                    lexer.reset();
                    evalNode = new PreProParser(new CommonTokenStream(lexer)).expression().result;
                    return ((ExpressionNode) evalNode).execute(symbolTable).toString();
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }
}
