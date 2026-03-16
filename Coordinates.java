/*
 * The Coordinates class is used to store a single whole position on the cartesian plane.
 * We use it to store the positions of shapes, and the vertices of a triangles as well.
*/

public class Coordinates {
    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double distance(Coordinates p) {
        return Math.sqrt((this.getX()-p.getX())*(this.getX()-p.getX())+(this.getY()-p.getY())*(this.getY()-p.getY()));
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y *= factor;
        }
    }

    public String display() {
        return "X = " + this.x + ", Y = " + this.y;
    }
}
