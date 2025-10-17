package restaurant;

import java.util.List;

public class Holiday implements MenuStrategy {
    private static final double MODIFIER = 1.15;


    @Override
    public double cost(List<Meal> order, boolean isMember) {
        return order.stream().mapToDouble(meal -> meal.getCost() * MODIFIER).sum();
    }

    @Override
    public double modifier() {
        return MODIFIER;
    }
}
