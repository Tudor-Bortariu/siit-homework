package siit.midterm;

import java.util.Objects;

public class Triangle extends Shape{
    private final double base, firstSide, secondSide, height;

    public Triangle(double base, double firstSide, double secondSide, double height) {
        this.base = base;
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.height = height;
    }

    @Override
    public double getSurface() {
        return (base * height) / 2;
    }

    @Override
    public double getPerimeter() {
        return base + firstSide + secondSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0 && Double.compare(triangle.firstSide, firstSide) == 0 && Double.compare(triangle.secondSide, secondSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, firstSide, secondSide);
    }
}
