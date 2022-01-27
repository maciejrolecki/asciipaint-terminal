/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint;

import asciipaint.View.*;

/**
 *
 * @author marol
 */
public class Application {

    /**
     * Main method of the AsciiPaint Application.
     *
     * @param args arguments given to the main method. None were used here.
     */
    public static void main(String[] args) {
        start();
    }

    /**
     * Starts the application and communicates with the user.
     */
    public static void start() {
        View view = new View();
        view.displayMessage("Veuillez entrer la hauteur de votre tableau");
        int height = Controller.getInt();
        view.displayMessage("Veuillez entrer la largeur de votre tableau");
        int width = Controller.getInt();
        AsciiPaint ascii = new AsciiPaint(width, height);
        view.displayRecurrentMessage();
        boolean finished = false;
        while (!finished) {
            finished = Controller.interpretCommand(Controller.getCommand(), ascii);
        }
    }
}
