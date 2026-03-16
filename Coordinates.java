/*
 * The Coordinates class is used to store a single whole position on the cartesian plane.
 * We use it to store the positions of shapes, and the vertices of a triangles as well.
*/

public class Coordinates {
    private int x;
    private int y;

    // constructor that takes in two integers as the x, y positions.
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // get x value
    public int getX() {
        return this.x;
    }

    // get y value
    public int getY() {
        return this.y;
    }

    // get the distance between this point and the point p
    public double distance(Coordinates p) {
        return Math.sqrt((this.getX()-p.getX())*(this.getX()-p.getX())+(this.getY()-p.getY())*(this.getY()-p.getY()));
    }

    // translate point by dx in the x-axis and by dy in the y axis
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // scales point by factor. divides if sign is false
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y *= factor;
        }
    }

    // returns a string displaying information about the point.
    public String display() {
        return "X = " + this.x + ", Y = " + this.y;
    }
}
