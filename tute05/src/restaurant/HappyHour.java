package restaurant;

import java.util.List;

public class HappyHour implements MenuStrategy {
    private static final double MODIFIER = 0.7;
    private static final double MEMBER_MODIFIER = 0.6;

    @Override
    public double cost(List<Meal> order, boolean isMember) {
        if (isMember) {
            return order.stream().mapToDouble(meal -> meal.getCost() * MEMBER_MODIFIER).sum();
        } else {
            return order.stream().mapToDouble(meal -> meal.getCost() * MODIFIER).sum();
        }
    }

    @Override
    public double modifier() {
        return MODIFIER;
    }
}
