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
public interface Shape {

    /**
     * Moves the Point from a position by a given horizontal and vertical
     * transition.
     *
     * @param dx a given horizontal transition.
     * @param dy a given vertical transition.
     */
    abstract void move(double dx, double dy);

    /**
     * Defines if a given Point is inside the shape.
     *
     * @param p the point to check.
     * @return true if is inside, false otherwise.
     */
    abstract boolean isInside(Point p);

    /**
     * Method which returns given to a Colored Point
     *
     * @return a char representing the point.
     */
    abstract char getColor();

}
