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
public class Circle extends ColoredShape {

    private Point centre;
    private double radius;

    /**
     * Creates a new Circle with defined parameters.
     *
     * @param centre a given Point which represents the centre of the circle.
     * @param radius a given radius.
     * @param color  a char designated to represent the shape in the drawing.
     */
    public Circle(Point centre, double radius, char color) {
        super(color);
        this.centre = Objects.requireNonNull(centre, "centre absent");
        if (radius <= 0) {
            throw new IllegalArgumentException(" Le rayon doit être strictement positif");
        }
        this.radius = radius;
    }

    /**
     * Moves the circle's centre in a certain direction.
     *
     * @param dx the horizontal movement.
     * @param dy the vertical movement.
     */
    @Override
    public void move(double dx, double dy) {
        centre.move(dx, dy);
    }

    /**
     * Defines if a given Point is inside the shape.
     *
     * @param p the point to check.
     * @return true if is inside, false otherwise.
     */
    @Override
    public boolean isInside(Point p) {
        return centre.distanceTo(p) < radius;
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
        return "circle: centre x " + centre.getX() + " centre y " + centre.getY() + " radius " + radius + " group :"
                + group;
    }

}
