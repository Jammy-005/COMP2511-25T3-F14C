package calculator;

public class Value implements Expression {
    private double value;

    Value(double value) {
        this.value = value;
    }

    @Override
    public double calculate() {
        return value;
    }
}
