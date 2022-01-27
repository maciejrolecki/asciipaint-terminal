/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint;

import asciipaint.model.Circle;
import asciipaint.model.ColoredShape;
import asciipaint.model.Drawing;
import asciipaint.model.Line;
import asciipaint.model.Point;
import asciipaint.model.Rectangle;
import asciipaint.model.Square;
import java.util.List;

/**
 * Represents the Ascii converted shapes.
 *
 * @author marol
 */
public class AsciiPaint {

    private Drawing drawing;

    String defaultColor = "\u001b[0m";
    String redCharacter = "\u001b[31m";
    String greenCharacter = "\u001b[32m";
    String yellowCharacter = "\u001b[33m";
    String blueCharacter = "\u001b[34m";

    /**
     * Simple constructor of an Ascii drawing
     */
    public AsciiPaint() {
        this(50, 50);
    }

    /**
     * Constructor if an Ascii drawing with parameters.
     *
     * @param height corresponds with the drawings height.
     * @param width  corresponds with the drawings width.
     */
    public AsciiPaint(int height, int width) {
        this.drawing = new Drawing(height, width);
    }

    /**
     * Adds a new Circle with defined parameters to the drawing.
     *
     * @param x      the horizontal position.
     * @param y      the vertical position.
     * @param radius a given radius.
     * @param color  a char designated to represent the shape in the drawing.
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Adds a new Rectangle with defined parameters to the drawing.
     *
     * @param x      the horizontal position.
     * @param y      the vertical position.
     * @param width  a given width.
     * @param height a given height.
     * @param color  a char designated to represent the shape in the drawing.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Adds a new Square with defined parameters to the drawing.
     *
     * @param x     the horizontal position.
     * @param y     the vertical position.
     * @param side  the length of a side of the square.
     * @param color a char designated to represent the shape in the drawing.
     */
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

    /**
     * Adds a new Line with defined parameters to the drawing.
     * 
     * @param Ax    the horizontal position of the first point.
     * @param Ay    the vertical position of the first point.
     * @param Bx    the horizontal position of the second point.
     * @param By    the vertical position of the second point.
     * @param color a char designated to represent the shape in the drawing.
     */
    public void newLine(int Ax, int Ay, int Bx, int By, char color) {
        drawing.addShape(new Line(Ax, Ay, Bx, By, color));
    }

    /**
     * Converts the drawing to a single string.
     *
     * @return a String.
     */
    public String asAscii() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < drawing.getHeight(); row++) {
            for (int column = 0; column < drawing.getWidth(); column++) {
                Point point = new Point(column, row);
                ColoredShape shape = drawing.getShapeAt(point);
                String color = " ";
                if (shape != null) {
                    color = getColorGroup(shape.getColorGroup().toLowerCase()) + Character.toString(shape.getColor())
                            + defaultColor;
                }
                builder.append(color);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public List<ColoredShape> getShapes() {
        return drawing.getShapes();
    }

    public String getColorGroup(String color) {
        switch (color) {
            case "red":
                return redCharacter;
            case "yellow":
                return yellowCharacter;
            case "blue":
                return blueCharacter;
            case "green":
                return greenCharacter;
            case "black":
                return defaultColor;
            default:
                return defaultColor;
        }
    }

}
