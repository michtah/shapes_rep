abstract class Shape {
    /*
     * The coordinates of a shape is the top-leftmost coordinate (one with the lowest values).
     * Sides is how many sides a shape has.
     * The coordinates are updated, and can change if the bounding box changes.
     * For now, only scale() can do this.
     */
    private Coordinates position;
    private int sides;


    public Shape() {
        this.sides = 3;
        this.position = new Coordinates(0, 0);
    }

    public Shape(Coordinates position, int sides) {
        this.position = position;
        this.sides = sides;
    }

    
    public int getSides() {
        return this.sides;
    }

    public Coordinates getCoordinates() {
        return this.position;
    }

    public void setCoordinates(Coordinates position) {
        this.position = position;
    }

    // move object.
    public void translate(int dx, int dy) {
        this.position.translate(dx, dy);
    }

    abstract void scale(int factor, boolean sign);

    abstract double getArea();

    abstract double getPerimeter();

    abstract String display();
}
