public class Rectangle extends Shape {
    private int width;
    private int length;

    // constructs rectangle from position, width, and length
    public Rectangle(int width, int length, Coordinates position) {
        super(4, position);
        this.width = width;
        this.length = length;
    }

    // gets area of rectangle (ab)
    @Override
    double getArea() {
        return this.width * this.length;
    }

    // gets perimeter of rectangle (2a+2b)
    @Override
    double getPerimeter() {
        return 2*this.width + 2*this.length;
    }

    // scales rectangle side lengths and positions
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.width *= factor;
            this.length *= factor;
        }
        else {
            this.width /= factor;
            this.length /= factor;
        }
    }

    // displays information about rectangle
    @Override
    String display() {
        return "Rectangle at: " + this.getCoordinates().display() +
        "\nWidth: " + this.width +
        "\nLength: " + this.length +
        "\nArea: " + this.getArea() +
        "\nPerimeter: " + this.getPerimeter();
    }
}