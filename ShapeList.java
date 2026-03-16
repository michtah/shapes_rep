import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listofShapes;

    public ShapeList() {
        this.listofShapes = new ArrayList<Shape>();
    }

    public ShapeList(ArrayList<Shape> shapes) {
        this.listofShapes = shapes;
    }

    public ShapeList(Shape shape) {
        ArrayList<Shape> initList = new ArrayList<Shape>();
        initList.add(shape);
        
        this.listofShapes = initList;
    }


    public void addShape(Shape shape) {
        this.listofShapes.add(shape);
    }

    public void translateShapes(int dx, int dy) {
        for (Shape shape : listofShapes) {
            shape.translate(dx, dy);
        }
    }
    
    public Shape getShape(int pos) {
        return this.listofShapes.get(pos);
    }

    public void removeShape(int pos) {
        this.listofShapes.remove(pos);
    }
}