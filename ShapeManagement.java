public class ShapeManagement {
    public static void main(String[] args) {
        Square testSquare = new Square(2, new Coordinates(2, 2));
        System.out.println(testSquare.display());

        testSquare.translate(2, -2);
        System.out.println(testSquare.display());

        testSquare.scale(2, true);
        System.out.println(testSquare.display());

        testSquare.scale(-2, false);
        System.out.println(testSquare.display());

        try {
            testSquare.scale(0, false);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exc: " + e.getMessage());
        }
    }
}
