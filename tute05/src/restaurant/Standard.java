package restaurant;

import java.util.List;

public class Standard implements MenuStrategy {
    private static final double MODIFIER = 1;


    @Override
    public double cost(List<Meal> order, boolean isMember) {
        return order.stream().mapToDouble(meal -> meal.getCost()).sum();
    }

    @Override
    public double modifier() {
        return MODIFIER;
    }
}
