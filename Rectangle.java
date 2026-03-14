public class Rectangle extends Shape {
    private int width;
    private int length;


    public Rectangle() {
        super(new Coordinates(0, 0), 4);
        this.width = 1;
        this.length = 1;
    }

    public Rectangle(int width, int length) {
        super(new Coordinates(0, 0), 4);
        this.width = width;
        this.length = length;
    }

    public Rectangle(int width, int length, Coordinates position) {
        super(position, 4);
        this.width = width;
        this.length = length;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            if (factor > 0) {
                this.width *= factor;
                this.length *= factor;

                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() * factor,
                    super.getCoordinates().getY() * factor
                ));
            }

            if (factor < 0) {
                this.width *= -factor;
                this.length *= -factor;

                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() * factor - width,
                    super.getCoordinates().getY() * factor - length
                ));
            }

            if (factor == 0) {
                this.width = 0;
                this.length = 0;
                super.setCoordinates(new Coordinates());
            }
        }

        else {
            if (factor > 0) {
                this.width /= factor;
                this.length /= factor;

                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() / factor,
                    super.getCoordinates().getY() / factor
                ));
            }

            if (factor < 0) {
                this.width /= -factor;
                this.length /= -factor;

                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() / factor - width,
                    super.getCoordinates().getY() / factor - length
                ));
            }

            if (factor == 0) {
                throw new ArithmeticException("Cannot divide object scale by zero.");
            }
        }
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public double getPerimeter() {
        return (this.width + this.length) * 2;
    }

    @Override
    public String display() {
        return "Rectangle at " + super.getCoordinates().display() + ". Width: " + this.width + ", Length: " + this.length;
    }
}
