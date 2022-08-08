package siit.midterm;

import java.util.Objects;

public class Rectangle extends Shape{
        private final Double l, L;

    public Rectangle(Double l, Double L) {
        this.l = l;
        this.L = L;
    }

    @Override
    public double getSurface() {
        return l * L;
    }

    @Override
    public double getPerimeter() {
        return 2 * (l + L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(l, rectangle.l) && Objects.equals(L, rectangle.L);
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, L);
    }
}
