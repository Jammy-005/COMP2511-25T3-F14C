package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void additionTest() {
        Expression expression = new Add(new Value(7), new Value(8));
        Calculator calculator = new Calculator(expression);
        assertEquals(calculator.calculate(), 15, 0.001);
    }

    @Test
    public void subtractionTest() {
        Expression expression = new Subtract(new Value(7), new Value(8));
        Calculator calculator = new Calculator(expression);
        assertEquals(calculator.calculate(), -1, 0.001);
    }

    @Test
    public void multiplicationTest() {
        Expression expression = new Multiply(new Value(7), new Value(8));
        Calculator calculator = new Calculator(expression);
        assertEquals(calculator.calculate(), 56, 0.001);
    }

    @Test
    public void divisionTest() {
        Expression expression = new Divide(new Value(7), new Value(8));
        Calculator calculator = new Calculator(expression);
        assertEquals(calculator.calculate(), 0.875, 0.001);
    }

    @Test
    public void layeredTest() {
        Expression expression = new Multiply(new Add(new Value(1), new Value(1)), new Divide(new Value(5), new Value(5)));
        Calculator calculator = new Calculator(expression);
        assertEquals(calculator.calculate(), 2, 0.001);
    }
}
