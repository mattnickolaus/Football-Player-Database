/*
 * Filename: App.java
 * Short description:App class with the main method, creating the model, view, controller and passes the model and
 *                   view for the controller class to have access and output.
 * IST 242 Assignment: W14-L06
 * @author  Matthew Nickolaus
 * @version 12/05/2023
 */
import Controller.Controller;
import Model.Model;
import View.View;

public class App {
    //defines main application method

    public static void main(String[] args) {
        //declare variables

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

    }
}