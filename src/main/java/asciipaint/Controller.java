/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciipaint;

import asciipaint.View.View;
import asciipaint.model.ColoredShape;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marol
 */
public class Controller {

    static int groupNumS = 1;

    /**
     * Asks the user for a command and divides it into tokens separated by a space.
     *
     * @return am array of strings.
     */
    public static String[] getCommand() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[] result = command.split("\\s");
        return result;
    }

    /**
     * Asks the user for an Integer
     *
     * @return the given integer.
     */
    public static int getInt() {
        View view = new View();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            view.displayMessage("invalid entry");
        }
        return scanner.nextInt();
    }

    /**
     * Interprets the given commands and applies them to the drawing.
     *
     * @param command a given command.
     * @param ascii   the object to which every shape will be added.
     * @return a boolean declaring if the art piece is finished. Returns true if
     *         finished, else returns false.
     */
    public static boolean interpretCommand(String[] command, AsciiPaint ascii) {
        View view = new View();
        switch (command[0].toLowerCase()) {
            case "show":
                view.displayAsAscii(ascii);
                break;
            case "add": {
                try {
                    switch (command[1].toLowerCase()) {
                        case "rectangle": {
                            ascii.newRectangle(Integer.parseInt(command[2]), Integer.parseInt(command[3]),
                                    Integer.parseInt(command[4]), Integer.parseInt(command[5]), command[6].charAt(0));
                            break;
                        }
                        case "square": {
                            ascii.newSquare(Integer.parseInt(command[2]), Integer.parseInt(command[3]),
                                    Integer.parseInt(command[4]), command[5].charAt(0));
                            break;
                        }
                        case "circle": {
                            ascii.newCircle(Integer.parseInt(command[2]), Integer.parseInt(command[3]),
                                    Integer.parseInt(command[4]), command[5].charAt(0));
                            break;
                        }
                        case "line": {
                            ascii.newLine(Integer.parseInt(command[2]), Integer.parseInt(command[3]),
                                    Integer.parseInt(command[4]), Integer.parseInt(command[5]), command[6].charAt(0));
                            break;
                        }
                        default: {
                            view.displayMessage("invalid shape");
                            break;
                        }
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ef) {
                    view.displayMessage("Invalid data");
                }
                break;
            }
            case "group": {
                try {
                    ColoredShape shapeA = ascii.getShapes().get(Integer.parseInt(command[1]) - 1);
                    ColoredShape shapeB = ascii.getShapes().get(Integer.parseInt(command[2]) - 1);
                    if (shapeA.getGroup() == 0 && shapeB.getGroup() == 0) {
                        shapeA.setGroup(groupNumS);
                        shapeB.setGroup(groupNumS);
                        groupNumS++;
                    } else if (shapeA.getGroup() != 0 && shapeB.getGroup() == 0) {
                        shapeB.setGroup(shapeA.getGroup());
                        shapeB.setColorGroup(shapeA.getColorGroup());
                    } else if (shapeB.getGroup() != 0 && shapeA.getGroup() == 0) {
                        shapeA.setGroup(shapeB.getGroup());
                        shapeA.setColorGroup(shapeB.getColorGroup());
                    } else if (shapeB.getGroup() != 0 && shapeA.getGroup() != 0) {
                        int initialGroup = shapeB.getGroup();
                        int finalGroup = shapeA.getGroup();
                        for (int i = 0; i < ascii.getShapes().size(); i++) {
                            ColoredShape shape = ascii.getShapes().get(i);
                            if (shape.getGroup() == initialGroup) {
                                shape.setGroup(finalGroup);
                                shape.setColorGroup(shapeA.getColorGroup());
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    view.displayMessage("invalid input, no such shape on the list");
                }
                break;
            }
            case "move": {
                try {
                    int group = ascii.getShapes().get(Integer.parseInt(command[1]) - 1).getGroup();
                    if (group == 0) {
                        ascii.getShapes().get(Integer.parseInt(command[1]) - 1).move(Integer.parseInt(command[2]),
                                Integer.parseInt(command[3]));
                    } else {
                        for (int i = 0; i < ascii.getShapes().size(); i++) {
                            ColoredShape shape = ascii.getShapes().get(i);
                            if (shape.getGroup() == group) {
                                shape.move(Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    view.displayMessage("invalid input, no such shape on the list");
                }
                break;
            }
            case "remove": {
                try {
                    int group = ascii.getShapes().get(Integer.parseInt(command[1]) - 1).getGroup();
                    if (group == 0) {
                        ascii.getShapes().remove(Integer.parseInt(command[1]) - 1);
                    } else {
                        int ln = ascii.getShapes().size();
                        for (int i = 0; i < ln; i++) {
                            ColoredShape shape = ascii.getShapes().get(i);
                            if (shape.getGroup() == group) {
                                ascii.getShapes().remove(i);
                                ln--;
                                i--;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    view.displayMessage("invalid input, no such shape on the list");
                }
                break;
            }
            case "list": {
                List<ColoredShape> shapes = ascii.getShapes();
                for (int i = 0; i < shapes.size(); i++) {
                        int j = i + 1;
                        view.displayMessage(j + " " + shapes.get(i).toString());
                }
                break;
            }
            case "color": {
                try {

                    List<ColoredShape> shapes = ascii.getShapes();
                    int groupN = shapes.get(Integer.parseInt(command[1]) - 1).getGroup();
                    if (groupN != 0) {
                        for (ColoredShape shape : shapes) {
                            if (shape.getGroup() == groupN) {
                                shape.setColorGroup(command[2]);
                            }
                        }
                    } else {
                        shapes.get(Integer.parseInt(command[1]) - 1).setColorGroup(command[2]);
                    }
                    break;
                } catch (NumberFormatException ee) {
                    view.displayMessage("invalid entry for changing color of group");
                }
            }

            case "help":
                view.displayRecurrentMessage();
                break;
            case "end":
                return true;
            default:
                view.displayMessage("Invalid command");

                break;
        }
        return false;
    }
}
