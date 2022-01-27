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
public class Line extends ColoredShape {

    private Point endA;
    private Point endB;

    /**
     * Simple Line constructor.
     * 
     * @param xEndA the horizontal position of the first point.
     * @param Ay    the vertical position of the first point.
     * @param Bx    the horizontal position of the second point.
     * @param By    the vertical position of the second point.
     * @param color a char designated to represent the shape in the drawing.
     */
    public Line(int xEndA, int yEndA, int xEndB, int yEndB, char color) {
        super(color);
        this.endA = new Point(xEndA, yEndA);
        this.endB = new Point(xEndB, yEndB);
    }

    /**
     * Moves the Line's extremities in a certain direction.
     *
     * @param dx the horizontal movement.
     * @param dy the vertical movement.
     */
    @Override
    public void move(double dx, double dy) {
        this.endA.move(dx, dy);
        this.endB.move(dx, dy);
    }

    /**
     * Defines if a given Point is inside the shape.
     *
     * @param p the point to check.
     * @return true if is inside, false otherwise.
     */
    @Override
    public boolean isInside(Point p) {
        if ((endA.getX() >= p.getX() && p.getX() >= endB.getX() || endB.getX() >= p.getX() && p.getX() >= endA.getX())
                && (endA.getY() >= p.getY() && p.getY() >= endB.getY()
                        || endB.getY() >= p.getY() && p.getY() >= endA.getY())) {
            return 1 > ((((endA.getY() - endB.getY()) * p.getX()) + ((endB.getX() - endA.getX()) * p.getY())
                    + (endA.getX() * endB.getY()) - (endB.getX() * endA.getY()))
                    / Math.sqrt(Math.pow(endB.getX() - endA.getX(), 2) + Math.pow(endB.getY() - endA.getY(), 2)))
                    && -1 < ((((endA.getY() - endB.getY()) * p.getX()) + ((endB.getX() - endA.getX()) * p.getY())
                            + (endA.getX() * endB.getY()) - (endB.getX() * endA.getY()))
                            / Math.sqrt(
                                    Math.pow(endB.getX() - endA.getX(), 2) + Math.pow(endB.getY() - endA.getY(), 2)));
        } else {
            return false;
        }
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
        return "line: A x " + this.endA.getX() + " A y " + this.endA.getY() + " B x " + this.endB.getX() + " B y "
                + this.endB.getY() + " group :" + group;
    }

}
