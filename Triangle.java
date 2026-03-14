public class Triangle extends Shape {
    // ! THESE ARE RELATIVE TO THE TOP-LEFT CORNER OF THE BOUNDING BOX OF THE TRIANGLE !
    // ! BE CAREFUL !
    private Coordinates p1;
    private Coordinates p2;
    private Coordinates p3;

    public Triangle() {
        super(new Coordinates(), 3);
        this.p1 = new Coordinates(0, 0);
        this.p2 = new Coordinates(1, 0);
        this.p3 = new Coordinates(0, 1);
    }

    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        int bounding_x = p1.getX();
        int bounding_y = p1.getY();
        if (p2.getX() < bounding_x) bounding_x = p2.getX();
        if (p2.getY() < bounding_y) bounding_y = p2.getY();
        if (p3.getX() < bounding_x) bounding_x = p3.getX();
        if (p3.getY() < bounding_y) bounding_y = p3.getY();

        Coordinates p1_r = new Coordinates(p1.getX() - bounding_x, p1.getY() - bounding_y);
        Coordinates p2_r = new Coordinates(p2.getX() - bounding_x, p2.getY() - bounding_y);
        Coordinates p3_r = new Coordinates(p3.getX() - bounding_x, p3.getY() - bounding_y);

        super(new Coordinates(bounding_x, bounding_y), 3);
        this.p1 = p1_r;
        this.p2 = p2_r;
        this.p3 = p3_r;
    }


    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            if (factor > 0) {
                this.p1 = new Coordinates(
                    this.p1.getX() * factor,
                    this.p1.getY() * factor
                );
                this.p2 = new Coordinates(
                    this.p2.getX() * factor,
                    this.p2.getY() * factor
                );
                this.p3 = new Coordinates(
                    this.p3.getX() * factor,
                    this.p3.getY() * factor
                );
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() * factor,
                    super.getCoordinates().getY() * factor
                ));
            }

            if (factor < 0) {
                // get the other side of the bounding box
                // // I'd like to note that while I stuck to naming conventions,
                // // I do prefer having subscripts like positionBox_x instead of positionBoxX,
                // // as this makes it easier to read for me.
                int otherBounding_x = this.p1.getX();
                int otherBounding_y = this.p1.getY();
                if (this.p2.getX() > otherBounding_x) otherBounding_x = this.p2.getX();
                if (this.p2.getY() > otherBounding_y) otherBounding_y = this.p2.getY();
                if (this.p3.getX() > otherBounding_x) otherBounding_x = this.p3.getX();
                if (this.p3.getY() > otherBounding_y) otherBounding_y = this.p3.getY();

                // mirror triangle across box and scale
                this.p1 = new Coordinates(
                    (otherBounding_x - this.p1.getX()) * -factor,
                    (otherBounding_y - this.p1.getY()) * -factor
                );
                this.p2 = new Coordinates(
                    (otherBounding_x - this.p2.getX()) * -factor,
                    (otherBounding_y - this.p2.getY()) * -factor
                );
                this.p3 = new Coordinates(
                    (otherBounding_x - this.p3.getX()) * -factor,
                    (otherBounding_y - this.p3.getY()) * -factor
                );
                
                // mirror bounding box point
                this.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() * factor,
                    this.getCoordinates().getY() * factor
                ));

                // move back because the two possible bounds have switched
                this.translate(otherBounding_x * factor, otherBounding_y * factor);
            }

            if (factor == 0) {
                this.p1 = new Coordinates();
                this.p2 = new Coordinates();
                this.p3 = new Coordinates();
                this.setCoordinates(new Coordinates());
            }
        }
        else {
            if (factor > 0) {
                this.p1 = new Coordinates(
                    this.p1.getX() / factor,
                    this.p1.getY() / factor
                );
                this.p2 = new Coordinates(
                    this.p2.getX() / factor,
                    this.p2.getY() / factor
                );
                this.p3 = new Coordinates(
                    this.p3.getX() / factor,
                    this.p3.getY() / factor
                );
                super.setCoordinates(new Coordinates(
                    super.getCoordinates().getX() / factor,
                    super.getCoordinates().getY() / factor
                ));
            }

            if (factor < 0) {
                // get the other side of the bounding box
                int otherBounding_x = this.p1.getX();
                int otherBounding_y = this.p1.getY();
                if (this.p2.getX() > otherBounding_x) otherBounding_x = this.p2.getX();
                if (this.p2.getY() > otherBounding_y) otherBounding_y = this.p2.getY();
                if (this.p3.getX() > otherBounding_x) otherBounding_x = this.p3.getX();
                if (this.p3.getY() > otherBounding_y) otherBounding_y = this.p3.getY();

                // mirror triangle across box and scale
                this.p1 = new Coordinates(
                    (otherBounding_x - this.p1.getX()) / -factor,
                    (otherBounding_y - this.p1.getY()) / -factor
                );
                this.p2 = new Coordinates(
                    (otherBounding_x - this.p2.getX()) / -factor,
                    (otherBounding_y - this.p2.getY()) / -factor
                );
                this.p3 = new Coordinates(
                    (otherBounding_x - this.p3.getX()) / -factor,
                    (otherBounding_y - this.p3.getY()) / -factor
                );
                
                // mirror bounding box point
                this.setCoordinates(new Coordinates(
                    this.getCoordinates().getX() / factor,
                    this.getCoordinates().getY() / factor
                ));

                // move back because the two possible bounds have switched
                this.translate(otherBounding_x / factor, otherBounding_y / factor);
            }

            if (factor == 0) {
                throw new ArithmeticException("Cannot divide scale by zero.");
            }
        }
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public double getArea() {
        double semiperimeter = this.getPerimeter() * 0.5;
        return Math.sqrt(
            semiperimeter *
            (semiperimeter - p1.distance(p2)) *
            (semiperimeter - p2.distance(p3)) *
            (semiperimeter - p3.distance(p1))
        );
    }

    @Override
    public String display() {
        return "Triangle with points: " +
        new Coordinates(
            this.p1.getX() + this.getCoordinates().getX(),
            this.p1.getY() + this.getCoordinates().getY()
        ).display() + " | " +
        new Coordinates(
            this.p2.getX() + this.getCoordinates().getX(),
            this.p2.getY() + this.getCoordinates().getY()
        ).display() + " | " +
        new Coordinates(
            this.p3.getX() + this.getCoordinates().getX(),
            this.p3.getY() + this.getCoordinates().getY()
        ).display() +
        " (bounding box corner: " + this.getCoordinates().display() + ")";
    }
}
