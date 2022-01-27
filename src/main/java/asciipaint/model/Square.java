/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.model;

/**
 *
 * @author marol
 */
public class Square extends Rectangle {

    /**
     * Creates a new Square with defined parameters.
     *
     * @param upperLeft represents the corresponding Point on the drawing.
     * @param side      the length of a side of the square.
     * @param Color     a char designated to represent the shape in the drawing.
     */
    public Square(Point upperLeft, double side, char Color) {
        super(upperLeft, side, side, Color);
    }

    /**
     * Is meant dor the List display in the game.
     */
    @Override
    public String toString() {
        String group = "default";
        if (this.getGroup() != 0) {
            group = Integer.toString(this.getGroup());
        }
        return "square: Upper left corner x " + super.upperLeft.getX() + " Upper left corner y "
                + super.upperLeft.getY() + " side length " + super.height + " group :" + group;
    }
}
