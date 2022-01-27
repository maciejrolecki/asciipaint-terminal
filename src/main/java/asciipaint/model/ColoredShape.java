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
public abstract class ColoredShape implements Shape {

    private char color;
    private int group = 0;
    private String colorGroup = "black";

    /**
     * Constructor for a Colored Point
     *
     * @param color a given char representing the Colored Point.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Method which returns given to a Colored Point
     *
     * @return a char representing the point.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * Sets the character which will represent the Colored Point to a new one.
     *
     * @param color the new 'color'.
     */
    public void setColor(char color) {
        this.color = color;
    }

    /**
     * Getter for Group indicator.
     * 
     * @return the number of the group.
     */
    public int getGroup() {
        return group;
    }

    /**
     * Getter for the color of the group o shapes or shape.
     * 
     * @return th String representing the color.
     */
    public String getColorGroup() {
        return colorGroup;
    }

    /**
     * Setter for group color.
     * 
     * @param colorGroup the new group or shape color.
     */
    public void setColorGroup(String colorGroup) {
        this.colorGroup = colorGroup;
    }

    /**
     * Setter for group indicator.
     * 
     * @param group the new group number
     */
    public void setGroup(int group) {
        this.group = group;
    }

}
