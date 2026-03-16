/*
 * The shape class is the parent of all shape types of the project. It stores the position of the object
 * and the number of sides. 
 */

abstract class Shape {
    private Coordinates position;
    private int sides;

    // constructor for object. takes the number of sides and the coordinates.
    public Shape(int noOfSides, Coordinates coord) {
        this.position = coord;
        this.sides = noOfSides;
    }

    // gets the coordinates of the shape.
    public Coordinates getCoordinates() {
        return position;
    }

    // gets the number of sides of the shape.
    public int getSides() {
        return sides;
    }

    // sets the coordinates of the shape.
    public void setCoordinates(Coordinates newcoord) {
        this.position = newcoord;
    }

    // translates shape (by calling Coordinates.translate on its position aspect)
    public void translate(int dx, int dy) {
        this.position.translate(dx, dy);
    }
    // scales shape position (by calling Coordinates.scale on its position aspect)
    public void scale(int factor, boolean sign) {
        this.position.scale(factor, sign);
    }

    abstract double getArea(); // will get the area of shape
    abstract double getPerimeter(); // will get perimeter of shape
    abstract String display(); // will display information about the shape
}
