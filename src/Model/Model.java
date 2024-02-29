/*
 * Filename: Model.java
 * Short description: This is an even more generic model class that has delegated more of its functions to
 *                  FootballPlayerData.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

public class Model {

    private FootballPlayerData fpData;

    public Model()
    {
        fpData = new FootballPlayerData();
    }

    public FootballPlayerData getFpData()
    {
        return fpData;
    }

    public void setFpData(FootballPlayerData fpd)
    {
        this.fpData = fpd;
    }
}
