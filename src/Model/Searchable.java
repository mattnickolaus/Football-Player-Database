/*
 * Filename: Searchable.java
 * Short description: This class...
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/5/2023
 */

/**
 * @author mattn
 * @version 1.0 12/5/2023
 */

package Model;

public interface Searchable {
    public boolean search(String searchTerm);

    public int getFoundIndex();
    public void setFoundIndex(int tableMemberindex);

    public boolean getFound();
    public void setFound(boolean searchResult);

    public int getSearchByField();
    public void setSearchByField(int fieldIndex);
}
