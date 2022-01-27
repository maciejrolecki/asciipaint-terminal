/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.model;

import java.util.Objects;

/**
 *
 * @author marol
 */
public class Rectangle extends ColoredShape {

    Point upperLeft;
    double width;
    double height;

    /**
     * Creates a new Rectangle with defined parameters.
     *
     * @param upperLeft represents the corresponding Point on the drawing.
     * @param width     a given width.
     * @param height    a given height.
     * @param color     a char designated to represent the shape in the drawing.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = Objects.requireNonNull(upperLeft, "coin absent");
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(" Les cotés doivent être strictement positifs");
        }
        this.height = height;
        this.width = width;
    }

    /**
     * Moves the rectangle's upper left corner in a certain direction.
     *
     * @param dx the horizontal movement.
     * @param dy the vertical movement.
     */
    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    /**
     * Defines if a given Point is inside the shape.
     *
     * @param p the point to check.
     * @return true if is inside, false otherwise.
     */
    @Override
    public boolean isInside(Point p) {
        return upperLeft.getX() <= p.getX() && upperLeft.getX() + width > p.getX() && upperLeft.getY() <= p.getY()
                && upperLeft.getY() + height > p.getY();
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
        return "rectangle: Upper left corner x " + this.upperLeft.getX() + " Upper left corner y "
                + this.upperLeft.getY() + " width " + this.width + " height " + this.height + " group :" + group;
    }

}
