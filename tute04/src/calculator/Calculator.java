package calculator;

/**
 * @author Nick Patrikeos
 **/
public class Calculator {
    private Expression expression;

    Calculator(Expression expression) {
        this.expression = expression;
    }

    public double calculate() {
        return expression.calculate();
    }
}
