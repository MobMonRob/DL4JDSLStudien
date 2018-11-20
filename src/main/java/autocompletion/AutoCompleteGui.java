package autocompletion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutoCompleteGui extends JFrame {
    private final AutoComplete autoComplete = new AutoComplete();
    private JTextArea textArea = new JTextArea();
    private JLabel label = new JLabel("function");

    public AutoCompleteGui() {
        setLayout(new BorderLayout());

        add(textArea, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        setSize(500, 500);
        setVisible(true);

        init();
    }

    public static void main(String[] args) {
        new AutoCompleteGui();
    }

    private void init() {
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                                               @Override
                                               public void run() {
                                                   Set<String> possibilities = autoComplete.tryAutoComplete(textArea.getText());
                                                   label.setText(String.join(" ", possibilities));
                                               }
                                           }
                );
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
    }
}
