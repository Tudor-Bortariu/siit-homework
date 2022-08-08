package siit.midterm;

import java.util.Objects;

public class Square extends  Shape{
    private final Double side;

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public double getSurface() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(side, square.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
