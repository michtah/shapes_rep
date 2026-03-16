public class Circle extends Shape {
    private int radius;

    // construct circle from position and radius. we let a circle have just one side.
    public Circle(int radius, Coordinates position) {
        super(1, position);
        this.radius = radius;
    }

    // gets area using πr²
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    // gets perimeter using 2πr
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // scales coordinates and radius
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) this.radius *= factor;
        else this.radius /= factor;
    }

    // displays some info about the circle
    @Override
    String display() {
        return "Circle at: " + this.getCoordinates().display() +
        "\nRadius: " + this.radius +
        "\nArea: " + this.getArea() +
        "\nPerimeter" + this.getPerimeter();
    }
}
