/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.View;

import asciipaint.AsciiPaint;

/**
 *
 * @author marol
 */
public class View implements InterfaceView {

    /**
     * Display to the user a given AsciiPaint object.
     *
     * @param ascii a given object.
     */
    @Override
    public void displayAsAscii(AsciiPaint ascii) {
        System.out.println(ascii.asAscii());
    }

    /**
     * Display a message given by the user.
     *
     * @param message a given message.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the message shown after each command.
     */
    @Override
    public void displayRecurrentMessage() {
        displayMessage(" The upper left corner displayed by show corresponds to the 0,0 position");
        displayMessage("The lower and further left you get from this position, the higher x and y coordinates get");
        displayMessage("");
        displayMessage("Please introduce a valid command");
        displayMessage("Should look like follows :");
        displayMessage("(case matters only for the displayed character of the shape)");
        displayMessage("show ( in order to display alle the shapes)");
        displayMessage("end ( in order to end this program)");
        displayMessage("help ( in order to display this message again)");
        displayMessage(
                "goup int(number from the list, if in a group gives its color to the other shape) int(number from the list, if in a group colors the whole group)");
        displayMessage(
                "list ( displays the list off added shapes with their attributes and which group they are part of)");
        displayMessage(
                "color int(number from the list, if in a group colors the whole group) color( either red, yellow, green, blue or black)");
        displayMessage(
                "(if either of the Shapes is in a group, it gives its color to the second one, if both of them are in a group, the first group gives its color to the second)");
        displayMessage(
                "move int( number from the list, if in a group moves the whole group) x( horizontal movement) y( vertical movement)");
        displayMessage("remove int( number from the list, if in a group removes the whole group)");
        displayMessage("add circle posX(int) posY(int) radius(int) color(char)");
        displayMessage("add rectangle posX(int) posY(int) width(int) height(int) color(char)");
        displayMessage("add square posX(int) posY(int) side(int) color(char)");
        displayMessage(
                "add line posAX(int, first point) posAY(int, first point) posBX(int, second point) posBY(int, second point) color(char)");
        displayMessage("");
    }

}
