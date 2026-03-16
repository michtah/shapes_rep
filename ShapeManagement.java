import java.util.ArrayList;
import java.util.Scanner;



public class ShapeManagement {
    // we have the scanner here as all the menu methods will access it.
    static Scanner userScanner = new Scanner(System.in);
    static ShapeList userShapes = new ShapeList(new ArrayList<>());

    // makes a rectangle from user input
    private static Rectangle makeRectangle() {
        System.out.println("Enter coordinates (x y): ");
        int x = userScanner.nextInt();
        int y = userScanner.nextInt();

        System.out.println("Enter width: ");
        int width = userScanner.nextInt();

        System.out.println("Enter length: ");
        int length = userScanner.nextInt();

        return new Rectangle(width, length, new Coordinates(x, y));
    }

    // makes a square from user input
    private static Square makeSquare() {
        System.out.println("Enter coordinates (x y): ");
        int x = userScanner.nextInt();
        int y = userScanner.nextInt();

        System.out.println("Enter side length: ");
        int side = userScanner.nextInt();

        return new Square(side, new Coordinates(x, y));
    }

    // makes a circle from user input
    private static Circle makeCircle() {
        System.out.println("Enter coordinates (x y): ");
        int x = userScanner.nextInt();
        int y = userScanner.nextInt();

        System.out.println("Enter radius: ");
        int radius = userScanner.nextInt();

        return new Circle(radius, new Coordinates(x, y));
    }

    // makes a triangle from user input
    private static Triangle makeTriangle() {
        System.out.println("Enter first coordinates (x1 y1): ");
        int x1 = userScanner.nextInt();
        int y1 = userScanner.nextInt();
        Coordinates p1 = new Coordinates(x1, y1);

        System.out.println("Enter second coordinates (x2 y2): ");
        int x2 = userScanner.nextInt();
        int y2 = userScanner.nextInt();
        Coordinates p2 = new Coordinates(x2, y2);

        System.out.println("Enter first coordinates (x3 y3): ");
        int x3 = userScanner.nextInt();
        int y3 = userScanner.nextInt();
        Coordinates p3 = new Coordinates(x3, y3);

        return new Triangle(p1, p2, p3);
    }
    
    // combine all of the shape makers into a single tool
    private static void makeShape() {
        System.out.println("Enter the type of shape to make:\n\t1: Rectangle\n\t2: Square\n\t3: Circle\n\t4: Triangle");
        int userChoice = userScanner.nextInt();

        Shape userShape = null;
        if (userChoice == 1) userShape = makeRectangle();
        else if (userChoice == 2) userShape = makeSquare();
        else if (userChoice == 3) userShape = makeCircle();
        else if (userChoice == 4) userShape = makeTriangle();
        else {
            System.out.println("Invalid shape type.");
            return;
        }

        userShapes.addShape(userShape);
    }

    // removes a shape, as long as it is in bounds. otherwise it prints an error message.
    private static void removeShape() {
        System.out.println("Enter x coordinate of shape: ");
        int x = userScanner.nextInt();
        System.out.println("Enter y coordinate of shape: ");
        int y = userScanner.nextInt();
        Coordinates userCoordinates = new Coordinates(x, y);

        for (int i = 0; i < userShapes.getNumberOfShapes(); i++) {
            if (userShapes.getShape(i).getCoordinates().equals(userCoordinates)) {
                userShapes.removeShape(i);
                return;
            }
        }
        System.out.println("No such shape found.");
    }

    // displays one shape in the user list.
    private static void displayOneShape() {
        System.out.println("Enter x coordinate of shape: ");
        int x = userScanner.nextInt();
        System.out.println("Enter y coordinate of shape: ");
        int y = userScanner.nextInt();
        Coordinates userCoordinates = new Coordinates(x, y);

        for (int i = 0; i < userShapes.getNumberOfShapes(); i++) {
            if (userShapes.getShape(i).getCoordinates().equals(userCoordinates)) {
                System.out.println(userShapes.getShape(i).display());
                return;
            }
        }
        System.out.println("No such shape found.");
    }

    // displays area and perimeter information about one shape in the user list. gets shape by coordinates
    private static void displayOnePerimeterArea() {
        System.out.println("Enter x coordinate of shape: ");
        int x = userScanner.nextInt();
        System.out.println("Enter y coordinate of shape: ");
        int y = userScanner.nextInt();
        Coordinates userCoordinates = new Coordinates(x, y);

        for (int i = 0; i < userShapes.getNumberOfShapes(); i++) {
            if (userShapes.getShape(i).getCoordinates().equals(userCoordinates)) {
                System.out.println("Area: " + userShapes.getShape(i).getArea() + "\nPerimeter: " + userShapes.getShape(i).getPerimeter());
                return;
            }
        }
        System.out.println("No such shape found.");
    }

    // displays all shapes in the user list.
    private static void displayShapes() {
        System.out.println(userShapes.display());
    }

    // translates all shapes in the user list.
    private static void translateShapes() {
        System.out.println("Enter x translation: ");
        int dx = userScanner.nextInt();
        System.out.println("Enter y translation: ");
        int dy = userScanner.nextInt();

        userShapes.translate(dx, dy);
    }

    // scales all shapes in the user list.
    private static void scaleShapes() {
        System.out.println("Divide scale or multiply? (0 for divide, 1 for multiply): ");
        int userSign = userScanner.nextInt();
        boolean sign = userSign == 1;
        System.out.println("Enter factor: ");
        int factor = userScanner.nextInt();

        try {
            userShapes.scale(factor, sign);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide factor by zero!");
        }

        return;
    }

    // the main loop of the program
    private static void userLoop() {
        System.out.println(
            "Enter command:\n\t1: Add a shape\n\t2: Remove shape (using coordinates)\n\t3: Info about one shape (using index)\n\t4: Get perimeter and area (using coordinates)\n\t5: Display all shapes\n\t6: Translate all shapes\n\t7: Scale all shapes\n\t0: Quit loop"
        );
        int userInput = userScanner.nextInt();

        while (userInput != 0) {
            switch (userInput) {
                case 1: makeShape(); break;
                case 2: removeShape(); break;
                case 3: displayOneShape(); break;
                case 4: displayOnePerimeterArea(); break;
                case 5: displayShapes(); break;
                case 6: translateShapes(); break;
                case 7: scaleShapes(); break;
                default:
                    System.out.println("Unrecognised command. Try again.");
                    break;
            }
            System.out.println(
                "Enter command:\n\t1: Add a shape\n\t2: Remove shape (using coordinates)\n\t3: Info about one shape (using index)\n\t4: Get perimeter and area (using coordinates)\n\t5: Display all shapes\n\t6: Translate all shapes\n\t7: Scale all shapes\n\t0: Quit loop"
            );
            userInput = userScanner.nextInt();
        }
        userScanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to shape tool.");
        userLoop();
        userScanner.close();
    }
}
