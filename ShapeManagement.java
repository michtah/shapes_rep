public class ShapeManagement {
    public static void main(String[] args) {
        Circle testCircle = new Circle();
        System.out.println(testCircle.display());

        testCircle.translate(1, 1);
        System.out.println(testCircle.display());

        testCircle.scale(2, true);
        System.out.println(testCircle.display());

        testCircle.scale(-2, false);
        System.out.println(testCircle.display());

        try {
            testCircle.scale(0, false);
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getCanonicalName() + ": "+ e.getMessage());
        }
    }
}
