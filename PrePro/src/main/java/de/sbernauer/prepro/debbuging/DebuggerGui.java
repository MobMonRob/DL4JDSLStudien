package de.sbernauer.prepro.debbuging;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DebuggerGui {
    private final File sourceFile;

    private List<Label> sourceLabels = new ArrayList<>();

    public DebuggerGui(File sourceFile) {

        this.sourceFile = sourceFile;

        try {

            // Setup terminal and screen layers
            Terminal terminal = null;
            terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));

            BasicWindow window = new BasicWindow();
            window.setHints(Collections.singletonList(Window.Hint.FULL_SCREEN));

            Panel mainPanel = new Panel();
            mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));

            Panel leftPanel = new Panel();
            leftPanel.setTheme(new SimpleTheme(TextColor.ANSI.BLACK,TextColor.ANSI.WHITE));
            mainPanel.addComponent(leftPanel.withBorder(Borders.singleLine("Sourcecode")));

            Panel rightPanel = new Panel();
            rightPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
            mainPanel.addComponent(rightPanel);

            Panel variablesPanel = new Panel();
            rightPanel.addComponent(variablesPanel.withBorder(Borders.singleLine("Variables")));

            Panel shellPanel = new Panel();
            rightPanel.addComponent(shellPanel.withBorder(Borders.singleLine("Commands")));

            window.setComponent(mainPanel);


            List<String> sourceCodeLines = Files.readAllLines(Paths.get(sourceFile.getAbsolutePath()));
            for (String sourceCodeLine : sourceCodeLines) {
                Label label = new Label(sourceCodeLine);
                sourceLabels.add(label);
                leftPanel.addComponent(label);
            }

            markLine(4);

            gui.addWindowAndWait(window);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void markLine(int lineNumber) {
        if(lineNumber - 1 >= sourceLabels.size()) {
            throw new IllegalArgumentException("");
        }
        sourceLabels.get(lineNumber - 1).setBackgroundColor(TextColor.ANSI.GREEN);
    }

    public static void main(String[] args) {
        args = new String[]{"src/test/java/foo.prepro"}; //FIXME TODO

        if (args.length != 1) {
            throw new IllegalArgumentException("Must have one argument: The path to the file to be executed.");
        }
        System.out.println("=== PrePro-Debugger v0.1 ===");

        new DebuggerGui(new File(args[0]));
    }


}
