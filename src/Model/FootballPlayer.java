/*
 * Filename: FootballPlayer.java
 * Short description: Creates the football class by extending the person object and implementing TableMember. We then
 *                  defined the TableMember attribute and attribute name methods to return strings for each of the
 *                  values in Football and Person class. These methods will then be used for output in the controller.
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

public class FootballPlayer extends Person implements TableMember{
    // Instance Variables -- define your private data
    private int number;
    private String position;


    // Constructors
    public FootballPlayer() {
        // initialize default values
        super();
        this.number = 0;
        this.position = "N/A";
    }

    public FootballPlayer(String name, Height height, int weight, String hometown, String highSchool,
                          int number, String position) {
        // pass in data to initialize variables
        super(name, height, weight, hometown, highSchool);
        this.number = number;
        this.position = position;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }


    //Returns each value from a football player as a string
    @Override
    public String getAttribute(int n) {
        switch (n) {
            case 0:
                return String.valueOf(getNumber());
            case 1:
                return position;
            case 2:
                return super.getName();
            case 3:
                return super.getHeight().toString();
            case 4:
                return String.valueOf(super.getWeight());
            case 5:
                return super.getHometown();
            case 6:
                return super.getHighSchool();
            default:
                return "invalid input parameter";
        }
    }

    //Returns each value from a football player as an ArrayList of Strings
    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            data.add(getAttribute(i));
        }
        return data;
    }

    //Returns the name of a selected attribute from a football player as a string
    @Override
    public String getAttributeName(int n) {
        switch (n) {
            case 0:
                return "number";
            case 1:
                return "position";
            case 2:
                return "name";
            case 3:
                return "height";
            case 4:
                return "weight";
            case 5:
                return "hometown";
            case 6:
                return "highSchool";
            default:
                return "invalid input parameter";
        }
    }

    //Returns the name of a selected attribute from a football player as an ArrayList of strings
    @Override
    public ArrayList<String> getAttributeNames() {
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            name.add(getAttributeName(i));
        }
        return name;
    }


    //toString method for Football section player output
    @Override
    public String toString() {
        // return data as a String
        return super.toString() + " FootballPlayer{number=" + number + ", position=" + position + "}";
    }

}
