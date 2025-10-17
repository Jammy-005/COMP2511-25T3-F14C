package restaurant;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Restaurant {
    private MenuStrategy strategy = new Standard();
    private String name;
    private List<Meal> menu = new ArrayList<Meal>();
    private List<String> members = new ArrayList<String>();

    public Restaurant(String name) {
        this.name = name;
        JSONArray menuJSON = JSONHelper.readInData("src/restaurant/prices.json");

        for (Object Meal : menuJSON) {
            JSONObject jsonMeal = (JSONObject) Meal;
            menu.add(new Meal(jsonMeal.getString("meal"), jsonMeal.getInt("cost")));
        }
    }

    public double cost(List<Meal> order, String payee) {
        return strategy.cost(order, members.contains(payee));
    }

    public void setStrategy(MenuStrategy strategy) {
        this.strategy = strategy;
    }

    public void displayMenu() {
        double modifier = strategy.modifier();

        for (Meal meal : menu) {
            System.out.println(meal.getName() + " - " + meal.getCost() * modifier);
        }
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant("XS");
        r.displayMenu();
        System.out.println("------");
        r.setStrategy(new Holiday());
        r.displayMenu();
        System.out.println("------");
        r.setStrategy(new HappyHour());
        r.displayMenu();
    }
}
