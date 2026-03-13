/*
 * The Coordinates class is used to store a single whole position on the cartesian plane.
 * We use it to store the positions of shapes, and the vertices of a triangles as well.
*/

public class Coordinates {
    private int x;
    private int y;


    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public double distance(Coordinates p) {
        return Math.sqrt(
            Math.pow(p.getX() - this.getX(), 2) +
            Math.pow(p.getY() - this.getY(), 2)
        );
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
            this.y /= factor;
        }
    }

    public String display() {
        return "X: " + this.x + ", Y: " + this.y; 
    }
}
