/*
 * Filename: TableData.java
 * Short description: This TableData interface acts as a promise to implement these methods within the FootballPlayerData
 *                  class and acts a skeleton for them.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

import java.util.ArrayList;

public interface TableData
{

    // each of these methods are "promised" to be written in the FootballPlayerData class
    public void loadTable();

    public ArrayList<TableMember> getTable();

    public ArrayList<String> getHeaders();

    public ArrayList<String> getLine(int line);

    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);

}