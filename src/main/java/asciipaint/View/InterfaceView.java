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
public interface InterfaceView {

    /**
     * Display to the user a given AsciiPaint object.
     *
     * @param ascii a given object.
     */
    public void displayAsAscii(AsciiPaint ascii);

    /**
     * Display a message given by the user.
     *
     * @param message a given message.
     */
    public void displayMessage(String message);

    /**
     * Displays the message shown after each command.
     */
    public void displayRecurrentMessage();

}
