/*
 * Filename: Controller.java
 * Short description: Controller receives model and view objects, calls the method to set up the GUI panel from the view,
 *                  then calls the centerUpdate to add the data to the panel from the model. In this assignment we added
 *                  a scrolling MouseListener to scroll through the data set of all Football players. In addition, we
 *                  added a listener class that allows the button headers to change colors when clicked. We also added an
 *                  action listener for the west panel buttons to control the sorting of the data being displayed as
 *                  well as additional logic that allows the sortField or attribute of the player to be sorted from by
 *                  clicking on the headers. Now added functionality for searching via textField with methods from
 *                  the model and highlights the row that contains the searched for data in the view.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */

/**
 * @author mattn
 * @version 1.0 12/05/2023
 */

package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class Controller
{

    private Model model;
    private View view;
    private int start; // helps keep track of what button is highlighted

    public Controller(View v, Model m)
    {
        model = m;
        view = v;

        //Set up layout the view panel
        view.getMf().getIp().getCp().centerInitialSetup(model.getFpData().getLinesBeingDisplayed(),
                model.getFpData().getHeaders().size());
        //Adds data to the view panel
        view.getMf().getIp().getCp().centerUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(),
                        model.getFpData().getLastLineToDisplay()), // gets the lines
                model.getFpData().getHeaders()); //gets the headers
        //Add Listeners
        addScrolling();
        addListeners();
        addSorting();
        addTextFieldListener();
    }
    private void addTextFieldListener() {
        view.getMf().getIp().getNp().getTextField().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField obj = (JTextField) e.getSource();
                        String searchText = obj.getText();
                        int foundIndex;
                        // get access to sort/search
                        model.getFpData().setSearchByField(model.getFpData().getSortField());
                        boolean result = model.getFpData().search(searchText);
                        // reset the previously highlighted row
                        setHighlightRow(start, start + 7, null); //set buttons to original color
                        // ^Null in this case is default buttons color
                        // if found is true
                        if (result) {
                            foundIndex = model.getFpData().getFoundIndex();
                            System.out.println("Found Index: " + foundIndex);
                            if (foundIndex < model.getFpData().getTable().size()
                                    - model.getFpData().getLinesBeingDisplayed()) {
                                
                                model.getFpData().setFirstLineToDisplay(foundIndex);
                                model.getFpData().setLastLineToDisplay(foundIndex +
                                        model.getFpData().getLinesBeingDisplayed() - 1);
                                model.getFpData().setLineToHighlight(foundIndex);
                                start = 0;
                            } // first row highlight
                            else {
                                model.getFpData().setLastLineToDisplay(model.getFpData().getTable().size() -1);

                                model.getFpData().setFirstLineToDisplay(model.getFpData().getLastLineToDisplay() -
                                        model.getFpData().getLinesBeingDisplayed() - 1);
                                start = (foundIndex - model.getFpData().getFirstLineToDisplay()) * 7;
                            } // last 20 rows

                            // handles the highlight
                            setHighlightRow(start, start + 7, Color.YELLOW);
                            view.getMf().getIp().getCp().centerUpdate(
                                    model.getFpData().getLines(
                                            model.getFpData().getFirstLineToDisplay(),
                                            model.getFpData().getLastLineToDisplay()),
                                    model.getFpData().getHeaders()
                                    );
                            // set background of search field
                            view.getMf().getIp().getNp().getTextField().setBackground(Color.WHITE);
                        } // end if found true
                        else {
                            view.getMf().getIp().getNp().getTextField().setBackground(Color.RED);
                            view.getMf().getIp().getNp().getTextField().setOpaque(true);
                            setHighlightRow(start, start + 7, null);
                        } // not found
                    }
                }
        );
    }
    // method for setting the highlight
    private void setHighlightRow(int start, int stop, Color color) {
        for (int i = start; i < stop; i++){
            view.getMf().getIp().getCp().getButtons().get(i).setBackground(color);
        }
    }


    private void addSorting(){
        // selection sort
        view.getMf().getIp().getWp().getSelection().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getFpData().sort(1, model.getFpData().getSortField());
                // handle buttons in view
                view.getMf().getIp().getWp().getSelection().setSelected(true);
                // resetting other radio buttons
                view.getMf().getIp().getWp().getMerge().setSelected(false);
                view.getMf().getIp().getWp().getQuick().setSelected(false);

            }
        });
        // Merge Sort
        view.getMf().getIp().getWp().getMerge().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getFpData().sort(2, model.getFpData().getSortField());
                // handle buttons in the view
                view.getMf().getIp().getWp().getMerge().setSelected(true);
                // resetting other radio buttons
                view.getMf().getIp().getWp().getSelection().setSelected(false);
                view.getMf().getIp().getWp().getQuick().setSelected(false);
            }
        });
        // Quick Sort
        view.getMf().getIp().getWp().getQuick().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getFpData().sort(3, model.getFpData().getSortField());
                // handle buttons in the view
                view.getMf().getIp().getWp().getQuick().setSelected(true);
                // resetting other radio buttons
                view.getMf().getIp().getWp().getMerge().setSelected(false);
                view.getMf().getIp().getWp().getSelection().setSelected(false);
            }
        });
    }




    // Implemented MouseWheelListener to scroll through data set
    private void addScrolling(){
        view.getMf().getIp().getCp().addMouseWheelListener(
                new MouseWheelListener() {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent e) {
                        int units = e.getUnitsToScroll();
                        System.out.println("Units: " + units); // testing values in console
                        // sets the first line being displayed at a time
                        int first = model.getFpData().getFirstLineToDisplay() + units;
                        System.out.println("first: " + first); // testing values in console
                        // Validating that first is positive -- ensures you can't scroll back past the first line
                        if (first < 0) first = 0;
                        // Validates that you cannot scroll past the last line of data in the set
                        if (first > model.getFpData().getTable().size() - model.getFpData().getLinesBeingDisplayed()){
                            first -= units;
                        }
                        System.out.println("first 2:"+ first); // testing values in console
                        // Sets the last line being displayed at a time
                        int last = first + model.getFpData().getLinesBeingDisplayed() - 1;
                        System.out.println("Last:" + last); // testing values in console
                        System.out.println("----------");
                        // resets variables in FootballPlayerData
                        model.getFpData().setFirstLineToDisplay(first);
                        model.getFpData().setLastLineToDisplay(last);
                        // updates the view and adds the data to the view panel
                        view.getMf().getIp().getCp().centerUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(),
                                        model.getFpData().getLastLineToDisplay()), // gets the lines
                                model.getFpData().getHeaders()); //gets the headers

                        // ** Changes Removes the highlighted line
                        setHighlightRow(start, start + 7, null);
                    }
                }
        );
    }



    // Inner Listener for Headers to change color when clicked
    private void addListeners(){
        final ArrayList<JButton> head = view.getMf().getIp().getCp().getHeaders();
        for (int i = 0; i < head.size(); i++){
            JButton btn = head.get(i);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton hd = (JButton) e.getSource();
                    // Loops through to reset all buttons to normal background color
                    for (int b = 0; b < head.size(); b++){
                        head.get(b).setBackground(Color.GRAY);
                        // Checks if clicked for setting the sort field
                        if (head.get(b) == hd){
                            model.getFpData().setSortField(b);
                            System.out.println("Sort b: " + model.getFpData().getSortField());
                        }
                    }

                    // changes background color of clicked button
                    hd.setBackground(Color.DARK_GRAY);
                    // Sort Data
                    model.getFpData().sort(model.getFpData().getSortType(), model.getFpData().getSortField());
                    System.out.println("Sort out: " + model.getFpData().getSortField());
                    // updates view with newly sorted data
                    view.getMf().getIp().getCp().centerUpdate(model.getFpData().getLines(
                            model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()
                    ), model.getFpData().getHeaders());
                }
            });
        }
    }
}
