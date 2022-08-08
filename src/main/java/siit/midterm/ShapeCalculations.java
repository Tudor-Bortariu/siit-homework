package siit.midterm;

import java.util.HashSet;
import java.util.Set;

public class ShapeCalculations {
    Set<Shape> shapes = new HashSet<>();

    public void addShape (Shape shape){
        for (Shape existingShape : shapes) {
            if (existingShape.hashCode() == shape.hashCode()){
                throw new IllegalArgumentException("Similar shape was already added.");
            }
        }
        shapes.add(shape);
    }

    public double perimeterCalculation (){
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.getPerimeter();
        }
        System.out.println(totalPerimeter);
        return totalPerimeter;
    }


    public double surfaceCalculation (){
        double totalSurface = 0;
        for (Shape shape : shapes) {
            totalSurface += shape.getSurface();
        }
        System.out.println(totalSurface);
        return totalSurface;
    }

    public void clearShapes(){
        shapes.clear();
    }
}
