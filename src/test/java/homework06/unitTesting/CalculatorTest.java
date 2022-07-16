package homework06.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework06.Calculator;

public class CalculatorTest {
    @Test
    public void test_calculator1(){
        Calculator calculator = new Calculator();

        Assertions.assertEquals(-80, calculator.calculate("10 cm + 100 mm - 1 m", "cm"));
    }

    @Test
    public void test_calculator2(){
        Calculator calculator = new Calculator();

        Assertions.assertEquals(110.1, calculator.calculate("10 mm + 100 dm + 1 m", "dm"));
    }

    @Test
    public void test_calculator3(){
        Calculator calculator = new Calculator();

        Assertions.assertEquals(-850, calculator.calculate("25 cm - 100 mm - 1 m", "mm"));
    }
}
