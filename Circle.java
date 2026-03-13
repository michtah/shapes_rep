public class Circle extends Shape {
    private int radius;

    public Circle() {
        super(new Coordinates(), 1);
        this.radius = 1;
    }

    public Circle(int radius) {
        super(new Coordinates(), 1);
        this.radius = radius;
    }

    public Circle(int radius, Coordinates position) {
        super(position, 1);
        this.radius = radius;
    }

    

    @Override
    void scale(int factor, boolean sign) {
        if (sign) {
            if (factor > 0) {
                this.radius *= factor;
                super.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() * factor,
                    this.getCoordinates().getY() * factor
                ));
            }

            if (factor < 0) {
                this.radius *= -factor;
                super.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() * factor - 2*radius,
                    this.getCoordinates().getY() * factor - 2*radius
                ));
            }

            if (factor == 0) {
                this.radius = 0;
                super.setCoordinates(new Coordinates());
            }
        }

        else {
            if (factor > 0) {
                this.radius /= factor;
                super.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() / factor,
                    this.getCoordinates().getY() / factor
                ));
            }

            if (factor < 0) {
                this.radius /= -factor;
                super.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() / factor - 2*radius,
                    this.getCoordinates().getY() / factor - 2*radius
                ));
            }
            
            if (factor == 0) {
                throw new ArithmeticException("Cannot divide scale by zero.");
            }
        }
    }

    @Override
    double getArea() {
        return 3.14159265358979323 * this.radius * this.radius;
    }

    @Override
    double getPerimeter() {
        return 6.28318530717958647 * this.radius;
    }

    @Override
    String display() {
        return "Circle at: " + this.getCoordinates().display() + ". Radius: " + this.radius;
    }
}
