public class Triangle extends Shape {
    private Coordinates p1;
    private Coordinates p2;
    private Coordinates p3;

    // construct triangle form points. we let p1 be the coordinate for our shape.
    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        super(3, p1);
    }

    // gets perimeter using distance formula between points
    @Override
    double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    // gets area using heron's formula: √(s(s-a)(s-b)(s-c)) where s = (a+b+c)/2
    @Override
    double getArea() {
        return Math.sqrt(
            this.getPerimeter()*0.5*
            (this.getPerimeter()*0.5 - p1.distance(p2))*
            (this.getPerimeter()*0.5 - p2.distance(p3))*
            (this.getPerimeter()*0.5 - p3.distance(p1))
        );
    }

    // translates triangle by translating p1, p2, and p3 (as well as the position of the parent shape properties)
    @Override
    public void translate(int dx, int dy) {
        p1.translate(dx, dy);
        p2.translate(dx, dy);
        p3.translate(dx, dy);
        super.setCoordinates(p1);
    }

    // scales triangle by scaling p1, p2, and p3 (and the position of the parent shape property)
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        p2.scale(factor, sign);
        p3.scale(factor, sign);
    }

    // displays some info about the triangle
    @Override
    String display() {
        return "Triangle. Vertices:\n\t" +
        p1.display() + "\n\t" + p2.display() + "\n\t" + p3.display() +
        "\nArea: " + this.getArea() +
        "\nPerimeter: " + this.getPerimeter();
    }
}
