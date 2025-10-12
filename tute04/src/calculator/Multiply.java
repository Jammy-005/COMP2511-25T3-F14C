package calculator;

public class Multiply implements Expression {
    private Expression expression1;
    private Expression expression2;

    Multiply(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public double calculate() {
        return expression1.calculate() * expression2.calculate();
    }
}