/*
 * Filename: MainFrame.java
 * Short description: The Main Frame sets up the initial panel and sets the basic GUI values and operations.
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

public class MainFrame extends JFrame {
    // Instance Variables -- define your private data
    private InitialPanel ip ;


    // Constructors
    public MainFrame() {
        super("W14-L06 - Nickolaus");
        // initialize default values
        ip = new InitialPanel();
        add(ip);
        //set up the JFrame '
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 480);
        setVisible(true);
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setIp(InitialPanel ip) {
        this.ip = ip;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public InitialPanel getIp() {
        return ip;
    }

}