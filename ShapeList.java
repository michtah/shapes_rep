import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listofShapes;
    
    // initialises shape list using an ArrayList.
    public ShapeList(ArrayList<Shape> shapes) {
        this.listofShapes = shapes;
    }

    // adds shape to list
    public void addShape(Shape s) {
        this.listofShapes.add(s);
    }

    // removes shape at position (while checking for bounds)
    public void removeShape(int pos) {
        if (pos < 0) throw new IndexOutOfBoundsException("Removal index invalid.");
        else if (pos >= this.listofShapes.size()) throw new IndexOutOfBoundsException("Removal index invalid.");
        else this.listofShapes.remove(pos);
    }

    // gets shape at position (while checking for bounds)
    public Shape getShape(int pos) {
        if (pos < 0) throw new IndexOutOfBoundsException("Getting index invalid.");
        else if (pos >= this.listofShapes.size()) throw new IndexOutOfBoundsException("Getting index invalid.");
        else return this.listofShapes.get(pos);
    }

    // translates all shapes in list
    public void translate(int dx, int dy) {
        for (Shape shape : listofShapes) {
            shape.translate(dx, dy);
        }
    }

    // scales all shapes in list
    public void scale(int factor, boolean sign) {
        for (Shape shape : listofShapes) {
            shape.scale(factor, sign);
        }
    }

    // gets area of shape at position (while checking for bounds)
    public double area(int pos) {
        if (pos < 0) throw new IndexOutOfBoundsException("Area index invalid.");
        else if (pos >= this.listofShapes.size()) throw new IndexOutOfBoundsException("Area index invalid.");
        else return this.getShape(pos).getArea();
    }

    // gets perimeter of shape at position (while checking for bounds)
    public double perimeter(int pos) {
        if (pos < 0) throw new IndexOutOfBoundsException("Perimeter index invalid.");
        else if (pos >= this.listofShapes.size()) throw new IndexOutOfBoundsException("Perimeter index invalid.");
        else return this.getShape(pos).getPerimeter();
    }

    // gets the length of the list (how many shapes there are)
    public int getNumberOfShapes() {
        return this.listofShapes.size();
    }

    // displays some info about all of the shapes in the shape list
    public String display() {
        String outString = "";
        for (Shape shape : listofShapes) {
            outString += "\n-------\n" + shape.display() + "\n------\n";
        }
        return outString;
    }
}