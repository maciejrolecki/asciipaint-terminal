/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author marol
 */
public class Drawing {

    private List<ColoredShape> shapes;
    private int height;
    private int width;

    /**
     * Default Constructor for a Drawing Object.
     */
    public Drawing() {
        this(100, 100);
    }

    /**
     * A Constructor for a Drawing Object with parameters defining its dimensions.
     *
     * @param height a given width.
     * @param width  a given height.
     */
    public Drawing(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Dimensions du dessin incorrectes");
        }
        this.height = height;
        this.width = width;
        this.shapes = new ArrayList<>();
    }

    /**
     * Adds a Shape to the Drawing Object.
     *
     * @param shape a given shape to be added to the Drawing object.
     */
    public void addShape(Shape shape) {
        Objects.requireNonNull(shape, "Shape absente");
        this.shapes.add((ColoredShape) shape);
    }

    /**
     * Getter for the height of the drawing.
     *
     * @return an int corresponding to the height of the drawing.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for the width of the drawing.
     *
     * @return an int corresponding to the width of the drawing.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Looks for a Shape that can be found on a given Position.
     *
     * @param point a position to check.
     * @return the first shape that was found otherwise null.
     */
    public ColoredShape getShapeAt(Point point) {
        ColoredShape shape = null;
        for (ColoredShape shap : shapes) {
            if (shap.isInside(point)) {
                return shap;
            }
        }
        return shape;
    }

    /**
     * Getter for all the shapes that are on the drawing.
     *
     * @return a List of Shapes.
     */
    public List<ColoredShape> getShapes() {
        return shapes;
    }

}
