/*
 * Filename: Sortable.java
 * Short description: Creates the sortable interface method in which the sorting methods are promised to be created in
 *                  the football player data class that define the sortingTypes and sortFields.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Model;

public interface Sortable {
    public void sort(int sortType, int sortField);
    public int getSortType();
    public void setSortType(int sortType);
    public int getSortField();
    public void setSortField(int sortField);
}
