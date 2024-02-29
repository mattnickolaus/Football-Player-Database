/*
 * Filename: NorthPanel.java
 * Short description: The class creates the North Panel which contains the textField that acts as our search bar in the
 *                  application. It contains a JLabel indicating this to the user and has a get method that allows the
 *                  searched term to be passed to the controller.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/5/2023
 */

/**
 * @author mattn
 * @version 1.0 12/5/2023
 */

package View;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    // Instance Variables -- define your private data
    private JTextField textField;


    // Constructors
    public NorthPanel() {
        // initialize default values
        setBackground(Color.DARK_GRAY);
        JLabel label = new JLabel("Enter Search Term:");
        label.setForeground(Color.WHITE);
        add(label);
        textField = new JTextField(25);
        add(textField);
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public JTextField getTextField() {
        return textField;
    }


}
