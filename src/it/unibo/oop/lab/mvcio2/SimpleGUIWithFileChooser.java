package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame("Simple GUI With File Chooser");
    private final Controller contr = new Controller();
    /**
     * Builds a new {@link SimpleGUI}.
     * 
     */
    public SimpleGUIWithFileChooser() {
        // set the main panel
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // create button save and a text area
        final JButton save = new JButton("save");
        final JTextArea textArea = new JTextArea();
        /*
         *  insert the text area and the bottom in the center 
         *  and south of the panel
         */
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        // actions done at the pressure of the save button
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    contr.save(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        // set a panel to insert in the north part of the main panel
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        // create a textField not editable
        final JTextField textField = new JTextField(contr.getCurrentFilePath());
        textField.setEditable(false);
        // create a button to search a file in the filesystem
        final JButton browse = new JButton("Browse");
        browse.addActionListener(new ActionListener() {
        // actions done at the pressure of the browse button
        @Override
        public void actionPerformed(final ActionEvent event) {
            final JFileChooser fileChooser = new JFileChooser();
            final int choosenResult = fileChooser.showSaveDialog(frame);
            switch (choosenResult) {
            case JFileChooser.APPROVE_OPTION:
                final File newFile = fileChooser.getSelectedFile();
                contr.setCurrentFile(newFile);
                textField.setText(newFile.getPath());
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                JOptionPane.showMessageDialog(textField,
                        choosenResult,
                        "Error,file not revealed",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        });
        //insert the textField and the browse button in the northPanel
        northPanel.add(textField, BorderLayout.CENTER);
        northPanel.add(browse, BorderLayout.LINE_END);
        //insert the northPanel in the mainPanel
        mainPanel.add(northPanel, BorderLayout.NORTH);
        //frame configuration
        frame.setContentPane(mainPanel);
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }
    /**
     * Makes the GUI visible.
     */
    private void display() {
        frame.setVisible(true);
    }
    /**
     * 
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
        gui.display();
    }
}
