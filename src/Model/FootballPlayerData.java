/*
 * Filename: FootballPlayerData.java
 * Short description: FootballPlayerData creates an ArrayList that stores the data that is decoded from the xml and
 *                  creates the method that was promised from the Table Data class that allow the retrieval of data
 *                  from the players Array that is created. It now also implements Displayable and assigns values and
 *                  methods that indicate which lines will be sent to the panel for display. In addition, the class now
 *                  implements sortable and contains all methods that define the sortType and Fields from which the data
 *                  will be sorted from. Each of the three sorting methods selection, merge and quick are defined in the
 *                  class as well as the compare methods that allow the player attributes to be compared in sorting. Now
 *                  implements searchable interface and contains the methods that create a Hashmap and search through
 *                  football player data to be sent to the controller.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

import org.w3c.dom.ls.LSOutput;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

public class FootballPlayerData implements TableData, Displayable, Sortable, Searchable {
    // Instance Variables
    private ArrayList<FootballPlayer> players;

    //Attributes needed for Displayable
    private int firstLineToDisplay;
    private int lineToHighlight;
    private int lastLineToDisplay;
    private int getLinesBeingDisplayed;

    // Attributes needed for Sortable
    private int sortType;
    private int sortField;
    private Comparator<FootballPlayer> field;

    //Attributes needed for Searchable
    private int foundIndex;
    private boolean found;
    private int searchByField;
    private HashMap<String, Integer> hashTable;


    //creates players Array to store and read data from the xml
    public FootballPlayerData() {
        players = new ArrayList<>();
        loadTable();

        //initialize displayable variables
        firstLineToDisplay = 0;
        lastLineToDisplay = 19;
        getLinesBeingDisplayed = 20;
    }

    //LoadTable runs the read players method and loads the data into players
    @Override
    public void loadTable() {
        ReadPlayersFromXML();
    }

    //Read players from xml decodes the data from the xml and stores them in the ArrayList players
    public void ReadPlayersFromXML() {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }

    //getTable returns the full table of data
    public ArrayList getTable(){
        return players;
    }

    //getHeaders returns an ArrayList of Strings with the names of the FootballPlayer headers
    public ArrayList<String> getHeaders(){
        ArrayList<String> headers = players.get(0).getAttributeNames();
        return headers;
    }

    //get Line returns an ArrayList of Strings with the values of FootballPlayer in a chosen line of the table
    public ArrayList<String> getLine(int line){
        ArrayList<String> data = players.get(line).getAttributes();
        return data;
    }

    // getLines retrieves a set of line from getLine and adds them to an array of arrays and returns an array of arrays
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine){
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++){
            ArrayList<String> line = getLine(i);
            data.add(line);
        }
        return data;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() {
        return lineToHighlight;
    }

    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return getLinesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineToDisplay = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        lineToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineToDisplay = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        getLinesBeingDisplayed = numberOfLines;
    }



    // Methods for Sortable

    @Override
    public void sort(int sortType, int sortField) {
        //sortType: 1) selection; 2) merge; 3) quick
        //sortField: range from 0 - 6;
        setSortType(sortType);
        setSortField(sortField);
        System.out.println("Sort Method:" + sortType + " " + sortField);

        switch (sortType) {
            case 1: //selection sort
                selectionSort();
                break;
            case 2: // Merge sort
                Collections.sort(players, field);
                break;
            case 3: // quick sort -- array
                FootballPlayer[] array = copyList(players);
                Arrays.sort(array, field);
                players = new ArrayList<FootballPlayer>(Arrays.asList(array));
                break;
        }
    }

    private FootballPlayer[] copyList(ArrayList<FootballPlayer> data) {
        FootballPlayer[] array= new FootballPlayer[data.size()];
        for (int i = 0; i < data.size(); i++){
            array[i] = data.get(i);
        }
        return array;
    }

    private void selectionSort() {
        for (int i = 0; i < players.size(); i++){
            int minPos = minimumPosition(players, i);
            swap(players, minPos, i);
        }
    }

    private int minimumPosition(ArrayList<FootballPlayer> a, int from) {
        int minPos = from;
        for (int i = from + 1; i < a.size(); i++){
            // trying to solve the problem of selection sorting incorrectly ordering player numbers and weight by the
            // first character in the number as a string rather than an integer
            if (field == sortByNumber) {
                int o1 = Integer.valueOf(a.get(i).getAttribute(sortField));
                int o2 = Integer.valueOf(a.get(minPos).getAttribute(sortField));
                if (o1 < o2)
                    minPos = i;
            }
            else if (field == sortByHeight) {
                int o1 = WholeHeight(a.get(i));
                int o2 = WholeHeight(a.get(minPos));
                if (o1 < o2)
                    minPos = i;
            }
            else if (a.get(i).getAttribute(sortField).compareTo(a.get(minPos).getAttribute(sortField)) < 0)
                minPos = i;
        }
        return minPos;
    }

    private void swap(ArrayList<FootballPlayer> a, int b, int c){
        FootballPlayer temp = a.get(b);
        a.set(b, a.get(c));
        a.set(c, temp);
    }

    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void setSortField(int sortField) {
        this.sortField = sortField;
        // set field comparator
        switch (sortField) {
            case 0:
                field  = sortByNumber; break;
            case 1:
                field = sortByPosition; break;
            case 2:
                field = sortByName; break;
            case 3:
                field = sortByHeight; break;
            case 4:
                field = sortByWeight; break;
            case 5:
                field = sortByHometown; break;
            case 6:
                field = sortByHighSchool; break; 
        }

        // number, position, name, height, weight, hometown, highSchool
    }

    Comparator<FootballPlayer> sortByNumber = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getNumber() < o2.getNumber()) return -1;
            if (o1.getNumber() == o2.getNumber()) return 0;
            return 1;
        }
    };

    Comparator<FootballPlayer> sortByPosition = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getPosition().compareTo(o2.getPosition());
        }
    };

    Comparator<FootballPlayer> sortByName = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return  o1.getName().compareTo(o2.getName());
        }
    };


    // Method for Calculating the players whole height in inches for comparable method
    public int WholeHeight (FootballPlayer o) {
        return (o.getHeight().getFeet()*12) + o.getHeight().getInches();
    }

    Comparator<FootballPlayer> sortByHeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (WholeHeight(o1) < WholeHeight(o2)) return -1;
            if (WholeHeight(o1) == WholeHeight(o2)) return 0;
            return 1;
        }
    };

    Comparator<FootballPlayer> sortByWeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getWeight() < o2.getWeight()) return -1;
            if (o1.getWeight() == o2.getWeight()) return 0;
            return 1;
        }
    };


    Comparator<FootballPlayer> sortByHometown = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getHometown().compareTo(o2.getHometown());
        }
    };

    Comparator<FootballPlayer> sortByHighSchool = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getHighSchool().compareTo(o2.getHighSchool());
        }
    };

    // Implements Methods needed for Searchable Interface
    @Override
    public boolean search(String searchTerm) {
        hashTable = new HashMap<String, Integer>();
        loadHashTable();
        // resort the table
        sort(1, sortField);

        // check for searchTerm
        if (hashTable.containsKey(searchTerm)) { // if we did not check if the search term existed we get runTime Error
            setFound(true);
            setFoundIndex(hashTable.get(searchTerm));
            setLineToHighlight(foundIndex); // or call getFoundIndex
            System.out.println("Found match: " + foundIndex);
        } else {
            setFound(false);
            System.out.println("Not found");
        }
        return found;
    }

    private void loadHashTable() {
        // loop to load table
        for (int i = 0; i < players.size(); i++){
            String data = players.get(i).getAttribute(searchByField);
            hashTable.put(data, i);
        }
        Iterator iter = hashTable.keySet().iterator();
        System.out.println("iterator: " + iter);
        while (iter.hasNext()) {
            String key = iter.next().toString();
            int value = hashTable.get(key);
            System.out.println(key + ": " + value);
        }
    }



    @Override
    public int getFoundIndex() {
        return foundIndex;
    }

    @Override
    public void setFoundIndex(int tableMemberindex) {
        foundIndex = tableMemberindex;
    }

    @Override
    public boolean getFound() {
        return found;
    }

    @Override
    public void setFound(boolean searchResult) {
        found = searchResult;
    }

    @Override
    public int getSearchByField() {
        return searchByField;
    }

    @Override
    public void setSearchByField(int fieldIndex) {
        searchByField = fieldIndex;
    }
}