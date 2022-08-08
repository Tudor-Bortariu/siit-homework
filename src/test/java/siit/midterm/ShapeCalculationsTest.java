package siit.midterm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ShapeCalculationsTest {
    ShapeCalculations shapeCalculations = new ShapeCalculations();

    Circle circle = new Circle(2.5);
    Circle duplicateCircle = new Circle(2.5);
    Square square = new Square(5.0);
    Rectangle rectangle = new Rectangle(2.5, 3.0);
    Triangle triangle = new Triangle(2.0, 3.0, 2.0, 2.5);

    @Test
    public void duplicate_Shapes_Test() {
        shapeCalculations.addShape(circle);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                shapeCalculations.addShape(duplicateCircle));

        String expectedMessage = "Similar shape was already added.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void perimeter_For_All_Types_Of_Shapes_Test(){

        shapeCalculations.addShape(circle);
        shapeCalculations.addShape(square);
        shapeCalculations.addShape(rectangle);
        shapeCalculations.addShape(triangle);


        Assertions.assertEquals(53.70796326794897, shapeCalculations.perimeterCalculation());
    }

    @Test
    public void surface_For_All_Types_Of_Shapes_Test(){

        shapeCalculations.addShape(circle);
        shapeCalculations.addShape(square);
        shapeCalculations.addShape(rectangle);
        shapeCalculations.addShape(triangle);

        Assertions.assertEquals(54.63495408493621, shapeCalculations.surfaceCalculation());
    }

    @Test
    public void single_Circle_Surface_Test(){

        shapeCalculations.addShape(circle);

        Assertions.assertEquals(19.634954084936208, shapeCalculations.surfaceCalculation());
    }

    @Test
    public void single_Square_Surface_Test(){

        shapeCalculations.addShape(square);

        Assertions.assertEquals(25, shapeCalculations.surfaceCalculation());
    }

    @Test
    public void single_Rectangle_Surface_Test(){

        shapeCalculations.addShape(rectangle);

        Assertions.assertEquals(7.5, shapeCalculations.surfaceCalculation());
    }

    @Test
    public void single_Triangle_Surface_Test(){

        shapeCalculations.addShape(triangle);

        Assertions.assertEquals(2.5, shapeCalculations.surfaceCalculation());
    }

    @Test
    public void single_Circle_Perimeter_Test(){

        shapeCalculations.addShape(circle);

        Assertions.assertEquals(15.707963267948966, shapeCalculations.perimeterCalculation());
    }

    @Test
    public void single_Square_Perimeter_Test(){

        shapeCalculations.addShape(square);

        Assertions.assertEquals(20, shapeCalculations.perimeterCalculation());
    }

    @Test
    public void single_Rectangle_Perimeter_Test(){

        shapeCalculations.addShape(rectangle);

        Assertions.assertEquals(11, shapeCalculations.perimeterCalculation());
    }

    @Test
    public void single_Triangle_Perimeter_Test(){

        shapeCalculations.addShape(triangle);

        Assertions.assertEquals(7, shapeCalculations.perimeterCalculation());
    }

}