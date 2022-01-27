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
public class Point {

    private double x;
    private double y;

    /**
     * Constructor for a Point object.
     *
     * @param x a horizontal position.
     * @param y a vertical position.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor by copy of a Point object.
     *
     * @param p the Point to copy.
     */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Moves the point in a certain direction.
     *
     * @param dx the horizontal movement.
     * @param dy the vertical movement.
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Verifies the distance to another Point object.
     *
     * @param other the other Point.
     * @return a double representing the distance between two points.
     */
    public double distanceTo(Point other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
    }

    /**
     * return the horizontal position.
     *
     * @return a double
     */
    public double getX() {
        return x;
    }

    /**
     * return the vertical position.
     *
     * @return a double
     */
    public double getY() {
        return y;
    }

}
