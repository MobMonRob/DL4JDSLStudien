//package main;
//
//import com.oracle.truffle.api.nodes.Node;
//import nodes.MainNode;
//import nodes.SymbolTable;
//import nodes.expression.ExpressionNode;
//import nodes.statement.StatementNode;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.ConsoleErrorListener;
//import parser.PreProLexer;
//import parser.PreProParser;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class OldDebugger {
//
//    private static final Scanner SCANNER = new Scanner(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//
//        args = new String[]{"src/test/java/test.prepro"}; //FIXME TODO
//
//        if (args.length != 1) {
//            throw new IllegalArgumentException("Must have one argument: The path to the file to be debuged.");
//        }
//        System.out.println("=== PrePro-Debugger v0.1 ===");
//
//        PreProLexer lexer = new PreProLexer(CharStreams.fromFileName(args[0]));
//        MainNode main = new PreProParser(new CommonTokenStream(lexer)).prepro().result;
//
//        while (true) {
//            System.out.print("(" + main.getLineNumber() + ")> ");
//
//            String input = SCANNER.nextLine();
//            switch (input) {
//                case "exit":
//                    System.exit(0);
//                    break;
//                case "step":
//                    if (!main.executeNext()) {
//                        System.exit(0);
//                    }
//                    break;
//                case "vars":
//                    SYMBOL_TABLE.dump();
//                    break;
//                default:
//                    if (input.startsWith("eval")) {
//                        System.out.println(evaluateExpression(input.substring(5)));
//                    } else {
//                        System.out.println("Error: Command \"" + input + "\" not found.");
//                    }
//                    break;
//            }
//        }
//    }
//
//    private static String evaluateExpression(String expression) {
//
//        try {
//            PreProLexer lexer = new PreProLexer(CharStreams.fromString(expression));
//            PreProParser parser = new PreProParser(new CommonTokenStream(lexer));
//            parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
//            Node evalNode = parser.statement().result;
//            if (evalNode != null) {
//                ((StatementNode) evalNode).executeVoid(null);
//                return "Executed";
//            } else {
//                lexer.reset();
//                evalNode = new PreProParser(new CommonTokenStream(lexer)).expression().result;
//                return ((ExpressionNode) evalNode).executeGeneric(null).toString();
//            }
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            return "Error: " + e.getMessage();
//        }
//    }
//}
