package restaurant;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Restaurant {
    private String chargingStrategy = "standard";
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
        return switch (chargingStrategy) {
            case "standard" -> order.stream().mapToDouble(meal -> meal.getCost()).sum();
            case "holiday" -> order.stream().mapToDouble(meal -> meal.getCost() * 1.15).sum();
            case "happyHour" -> {
                if (members.contains(payee)) {
                    yield order.stream().mapToDouble(meal -> meal.getCost() * 0.6).sum();
                } else {
                    yield order.stream().mapToDouble(meal -> meal.getCost() * 0.7).sum();
                }
            }
            default -> 0;
        };
    }

    public void displayMenu() {
        double modifier = switch (chargingStrategy) {
            case "standard" -> 1;
            case "holiday" -> 1.15;
            case "happyHour" -> 0.7;
            default -> 0;
        };

        for (Meal meal : menu) {
            System.out.println(meal.getName() + " - " + meal.getCost() * modifier);
        }
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant("XS");
        r.displayMenu();
    }
}
