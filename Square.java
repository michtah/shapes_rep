public class Square extends Shape {
    private int side;

    // construct square with side length and position
    public Square(int side, Coordinates position) {
        super(4, position);
        this.side = side;
    }

    // get area of square (a²)
    @Override
    double getArea() {
        return side * side;
    }

    // get perimeter of square (4a)
    @Override
    double getPerimeter() {
        return 4 * side;
    }

    // scale square: coordinates and side length
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) this.side *= factor;
        else this.side /= factor;
    }

    // display info about square
    @Override
    String display() {
        return "Square at: " + this.getCoordinates().display() +
        "\nSide length: " + this.side +
        "\nArea: " + this.getArea() +
        "\nPerimeter: " + this.getPerimeter();
    }
}
