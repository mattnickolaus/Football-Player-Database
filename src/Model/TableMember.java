/*
 * Filename: TableMember.java
 * Short description: The TableMember interface enables a class to be used in a Table Display application(in the future).
 *                  It has methods to return one selected attribute name as a String
 *                  or all attributes names as an array of Strings.
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

public interface TableMember {

    //getAttribute returns the value of selected attribute of a class.
    //The attribute is returned as a String independently of its original type.
    public String getAttribute(int n);


    //getAttributes returns the value of all attributes of a class.
    //The attributes are returned as a String ArrayList.
    public ArrayList<String> getAttributes();


    //getAttributeName returns the name of selected attribute of a class
    //The attribute is returned as a String
    public String getAttributeName(int n);


    //getAttributesNames returns the value of all names of the attributes of a class.
    //The names of the attributes are returned as a String ArrayList.
    public ArrayList<String> getAttributeNames();

}