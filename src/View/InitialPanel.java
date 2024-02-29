/*
 * Filename: InitialPanel.java
 * Short description: The Initial Panel initializes the center panel for display on the GUI. Now also initialized the
 *                  west panel that will contain the buttons to control the sorting of the data being displayed. In
 *                  addition, the North panel is created which will contain the search bar for passing searched terms
 *                  to the controller.
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

public class InitialPanel extends JPanel {
    // Instance Variables -- define your private data
    private CenterPanel cp;
    private WestPanel wp;
    private NorthPanel np;

    // Constructors
    public InitialPanel() {
        // set the layout
        setLayout(new BorderLayout());

        //creates new center panel
        cp = new CenterPanel();
        add(cp);

        // create the west panel
        wp = new WestPanel();
        add(wp, "West");

        // create the North Panel
        np = new NorthPanel();
        add(np, "North");
    }


    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public CenterPanel getCp() {
        return cp;
    }

    public WestPanel getWp() {
        return wp;
    }

    public NorthPanel getNp() {
        return np;
    }
}
