package restaurant;

import java.util.List;

public interface MenuStrategy {
    public double cost(List<Meal> order, boolean isMember);
    public double modifier();
}
