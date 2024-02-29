/*
 * Filename: CenterPanel.java
 * Short description: This Panel is in charge of displaying the data. It sets up the buttons and headers that take the
 *                  data for the football players. Center Initial Setup is the method that sets all the buttons and button
 *                  headers in the layout and amount needed for the data. CenterUpdate then loads the data onto the
 *                  buttons and labels.
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
import java.util.ArrayList;

public class CenterPanel extends JPanel {
    // Instance Variables -- define your private data
    private ArrayList<JButton> buttons;
    private ArrayList<JButton> headers;

    // Constructors
    public CenterPanel() {
        // initialize default values
        buttons = new ArrayList<JButton>();
        headers = new ArrayList<JButton>();
    }

    //set up the panel with buttons and labels
    public void centerInitialSetup (int rows, int columns) {
        //number of rows are coming from the amount of data with getLinesDisplayed + 1 for the header
        //number of columns are coming from our getAttributes
        //creates grid layout

        setLayout(new GridLayout(rows + 1, columns));
        //creates the Button headers
        for (int h = 0; h < columns; h++){
            JButton l = new JButton();
            // setting button background and text color
            l.setBackground(Color.GRAY);
            l.setForeground(Color.WHITE);
            // add to ArrayList
            headers.add(l);
            // add to panel
            add(l);
        }
        //create the buttons / data
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c ++){
                JButton b = new JButton();
                //add buttons to the ArrayList
                buttons.add(b);
                //add to panel
                add(b);
            }
        }
        validate();
        repaint();

    }

    public void centerUpdate (ArrayList<ArrayList<String>> data, ArrayList<String> headings){
        // Add Data to headings
        for (int h = 0; h < headings.size(); h++){
            headers.get(h).setText(headings.get(h));
        }
        // Add data to the buttons
        int b = 0;
        for (int d = 0; d < data.size(); d++){
            ArrayList<String> line = data.get(d); // looks at the row or line
            // adds record to the button row selected
            for (int i = 0; i < line.size(); i++){
                buttons.get(b).setText(line.get(i));
                b++;
            }

        }
        validate();
        repaint();
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public ArrayList<JButton> getHeaders() {
        return headers;
    }
}
