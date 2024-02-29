/*
 * Filename: Person.java
 * Short description: Sets the person object, constructors, encapsulation & toString
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;
public class Person {

    //bring the contents of your Person class from the first assignment


    // Instance Variables -- defining name, weight, hometown, & high school
    private String name;
    private Height height;
    private int weight;
    private String hometown;
    private String highSchool;

    // Default Constructor
    public Person()
    {
        // initialize default values
        name = "";
        height = new Height();
        weight = 0;
        hometown = "N/A";
        highSchool = "N/A";
    }

    // All parameter constructor
    public Person(String name, Height height, int weight, String hometown, String highSchool)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hometown = hometown;
        this.highSchool = highSchool;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setName(String name)
    {
        this.name = name;
    }
    public void setHeight(Height height){
        this.height = height;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public void setHometown(String hometown)
    {
        this.hometown = hometown;
    }
    public void setHighSchool(String highSchool)
    {
        this.highSchool = highSchool;
    }


    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public String getName()
    {
        return name;
    }
    public Height getHeight(){
        return height;
    }
    public int getWeight()
    {
        return weight;
    }
    public String getHometown()
    {
        return hometown;
    }
    public String getHighSchool()
    {
        return highSchool;
    }

    // Additional methods --  None


    // returns String for our Person object
    @Override
    public String toString()
    {
        // return data as a String
        return "Person{name=" + name + ", height =" + height.toString() + ", weight=" + weight + ", hometown=" + hometown +
                ", highSchool=" + highSchool +"}";
    }

}
