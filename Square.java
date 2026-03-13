public class Square extends Shape {
    private int side;

    public Square() {
        super(new Coordinates(), 4);
        this.side = 1;
    }

    public Square(int side) {
        super(new Coordinates(), 4);
        this.side = side;
    }

    public Square(int side, Coordinates position) {
        super(position, 4);
        this.side = side;
    }


    @Override
    void scale(int factor, boolean sign) {
        if (sign) {
            if (factor > 0) {
                this.side *= factor;
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() * factor,
                    super.getCoordinates().getY() * factor
                ));
            }

            if (factor < 0) {
                this.side *= -factor;
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() * factor - this.side,
                    super.getCoordinates().getY() * factor - this.side
                ));
            }

            if (factor == 0) {
                this.side = 0;
                super.setCoordinates(new Coordinates());
            }
        }

        else {
            if (factor > 0) {
                this.side /= factor;
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() / factor,
                    super.getCoordinates().getY() / factor
                ));
            }

            if (factor < 0) {
                this.side /= -factor;
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() / factor - this.side,
                    super.getCoordinates().getY() / factor - this.side
                ));
            }

            if (factor == 0) {
                throw new ArithmeticException("Cannot divide scale by zero.");
            }
        }
    }

    @Override
    double getArea() {
        return side*side;
    }

    @Override
    double getPerimeter() {
        return 4*side;
    }

    @Override
    String display() {
        return "Square at " + super.getCoordinates().display() + ". Side length: " + this.side;
    }
}
