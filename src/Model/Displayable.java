/*
 * Filename: Displayable.java
 * Short description: Second interface that is implemented by FootballPlayerData that sets methods for display values
 *                  indicating which lines are displayed and highlighted.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

public interface Displayable {

    // holds the index value for the number of the first line to be displayed
    public int getFirstLineToDisplay();
    // Will be used late to hold the number of the line on the screen that should be highlighted
    public int getLineToHighlight();
    // holds the index number of the last line to be displayed
    public int getLastLineToDisplay();
    // holds the number of lines that will appear on the screen at one time
    public int getLinesBeingDisplayed();

    public void setFirstLineToDisplay(int firstLine);
    public void setLineToHighlight(int highlightedLine);
    public void setLastLineToDisplay(int lastLine);
    public void setLinesBeingDisplayed(int numberOfLines);

}
