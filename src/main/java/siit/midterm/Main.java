package siit.midterm;


public class Main {
    public static void main(String[] args) {

        ShapeCalculations shapeCalculations = new ShapeCalculations();

        Shape circle = new Circle(2.0);
        Shape square = new Square(5.0);
        Shape square1 = new Square(5.0);

        shapeCalculations.addShape(circle);
        shapeCalculations.addShape(square);

        shapeCalculations.perimeterCalculation();
        shapeCalculations.surfaceCalculation();

        shapeCalculations.clearShapes();

        shapeCalculations.addShape(square1);
        shapeCalculations.surfaceCalculation();

    }
}
