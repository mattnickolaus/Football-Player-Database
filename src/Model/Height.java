/*
 * Filename: Height.java
 * Short description: Creates the height class that formats the data for the person/football player class
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

public class Height {


    // Instance Variables -- define your private data
    private int feet;
    private int inches;

    // Constructors

    //Default Constructor
    public Height() {
        // initialize default values
        feet = 0;
        inches = 0;
    }

    // Parameterized Constructor
    public Height(int f, int in) // pass in data to initialize variables
    {
        feet = f;
        inches = in;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setFeet(int feet){
        this.feet = feet;
    }

    public void setInches(int inches){
        this.inches = inches;
    }


    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public int getFeet(){
        return feet;
    }

    public int getInches(){
        return inches;
    }




    // toString Method
    @Override
    public String toString() {
        // return data as a String
        return feet + "'" + inches + '"';
    }

}