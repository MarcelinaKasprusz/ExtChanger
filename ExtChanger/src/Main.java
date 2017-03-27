import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Marcelina Kasprusz on 20.03.2017.
 */
public class Main {
    private JButton fileChooser;
    private JTextField extensionTextField;
    private JPanel main;
    private JTextField getPath;
    private JButton change;
    private JLabel word1;
    private JLabel word2;
    File file;
    String ext;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zmień rozszerzenie Twojego pliku");
        frame.setContentPane(new Main().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        String ext;
        File file;
    }

    public Main() {
        fileChooser.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(new File("System.getProperty(\"user.home\")"));
            int result = fileChooser.showOpenDialog(Main.this.main);
            if (result == JFileChooser.APPROVE_OPTION) {
                getPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
                file = fileChooser.getSelectedFile();
                ext = extensionTextField.getText().trim();   //jeśli z jFileChoosera

            }
        });
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File temp = new File(getPath.getText());
                if(temp.isFile()){   //jeśli wpisana ręcznie
                    file = temp;
                }

                changeExtension(file, ext);
                word2.setText("Plik został zmieniony!");
            }
        });
    }

    public static File changeExtension(File toChange, String ext) {
        String path = toChange.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf(".") + 1) + ext;
        File changed = new File(path);
        return toChange.renameTo(changed) ? changed : toChange;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        main = new JPanel();
        main.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(10, 10, 10, 10), -1, -1));
        fileChooser = new JButton();
        fileChooser.setText("Button");
        main.add(fileChooser, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        main.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extensionTextField = new JTextField();
        main.add(extensionTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }


}
