/*
 * Filename: WestPanel.java
 * Short description: This panel sets up the sorting buttons on the left side of the GUI. They are created as
 *                  radio buttons with a JLabel at the top which allows the user to select the sorting method after
 *                  defining the actionListener in the controller
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package View;

import javax.swing.*;
import java.awt.*;
public class WestPanel extends JPanel{
    // Instance Variables -- define your private data
    private JRadioButton selection;
    private JRadioButton merge;
    private JRadioButton quick;


    // Constructors
    public WestPanel() {
        // initialize default values
        setLayout(new GridLayout(4, 1, 5, 5));
        JLabel label = new JLabel("Choose SORT Type", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLUE);
        label.setOpaque(true);
        add(label);
        // Radio Buttons
        selection = new JRadioButton("Selection Sort");
        selection.setBackground(Color.LIGHT_GRAY);
        add(selection);
        merge = new JRadioButton("Merge Sort");
        merge.setForeground(Color.WHITE);
        merge.setBackground(Color.GRAY);
        add(merge);
        quick = new JRadioButton("Quick Sort");
        quick.setBackground(Color.LIGHT_GRAY);
        add(quick);
    }



    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public JRadioButton getSelection() {
        return selection;
    }

    public JRadioButton getMerge () {
        return merge;
    }

    public JRadioButton getQuick(){
        return quick;
    }



}
