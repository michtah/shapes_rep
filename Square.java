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


    
}
