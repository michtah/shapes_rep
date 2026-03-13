public class ShapeManagement {
    public static void main(String[] args) {
        Rectangle testRectangle = new Rectangle(6, 4, new Coordinates(2, 2));
        System.out.println(testRectangle.display());

        testRectangle.translate(2, 2);
        System.out.println(testRectangle.display());

        testRectangle.scale(-2, true);
        System.out.println(testRectangle.display());

        testRectangle.scale(2, false);
        System.out.println(testRectangle.display());

        try {
            testRectangle.scale(0, false);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }
    }
}
