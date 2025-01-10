package lldQuestions.coffeeVendingMachineDesign;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CoffeeMachine {
    private List<Coffee>coffeeMenu;
    private Map<String,Ingredient>ingredients;

    public CoffeeMachine(){
        this.coffeeMenu=new ArrayList<>();
        this.ingredients=new HashMap<>();

        initializeIngredients();
        initializeCoffeeMenu();
    }

    public void initializeCoffeeMenu(){
        Map<Ingredient,Integer>espressoRecipe=new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"),1);
        espressoRecipe.put(ingredients.get("Water"),1);
        coffeeMenu.add(new Coffee("Espresso", 2.0, espressoRecipe));

        Map<Ingredient,Integer>cappuccinoRecipe=new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("Water"),1);
        cappuccinoRecipe.put(ingredients.get("Coffee"),1);
        cappuccinoRecipe.put(ingredients.get("Milk"),1);
        coffeeMenu.add(new Coffee("Cappuccino", 3.0, cappuccinoRecipe));

        Map<Ingredient,Integer>latteRecipe=new HashMap<>();
        latteRecipe.put(ingredients.get("Milk"),2);
        latteRecipe.put(ingredients.get("Coffee"),1);
        latteRecipe.put(ingredients.get("Water"),1);
        coffeeMenu.add(new Coffee("Latte", 4.0, latteRecipe));
    }

    public void initializeIngredients(){
        ingredients.put("Coffee",new Ingredient("Coffee", 10));
        ingredients.put("Milk",new Ingredient("Milk",10 ));
        ingredients.put("Water",new Ingredient("Water", 10));
    }

    public void displayMenu(){
        System.out.println("Coffee Menu: ");
        for(Coffee coffee:coffeeMenu){
            System.out.println(coffee.getName()+" : "+coffee.getPrice());
        }
    }

    public Coffee selectCoffee(String coffeeName){
        for(Coffee coffee:coffeeMenu){
            if(coffee.getName().equalsIgnoreCase(coffeeName)){
                return coffee;
            }
        }
        return null;
    }

    public void dispenseCoffee(Coffee coffee, Payment payment){
        if(payment.getAmount()>=coffee.getPrice()){
            if(hasSufficientIngredients(coffee)){
                updateIngredient(coffee);
                System.out.println("Dispensing coffee: "+coffee.getName());
                double change=payment.getAmount()-coffee.getPrice();
                if(change>0){
                    System.out.println("Please collect your change: "+change);
                }
            }
            else{
                System.out.println("Sorry we have insufficient ingredients to despense your order.");
            }
        }
        else{
            System.out.println("You entered insufficient amount of "+payment.getAmount()+" for "+coffee.getPrice());
        }
    }

    public boolean hasSufficientIngredients(Coffee coffee){
        for(Map.Entry<Ingredient,Integer> entry:coffee.getRecipe().entrySet()){
            Ingredient ingredient=entry.getKey();
            Integer requiredQuantity=entry.getValue();
            if (ingredient == null || requiredQuantity > ingredient.getQuantity()) { 
                return false;
            }
        }
        return true;
    }

    public void updateIngredient(Coffee coffee){
        for(Map.Entry<Ingredient,Integer>entry:coffee.getRecipe().entrySet()){
            Ingredient ingredient=entry.getKey();
            Integer requiredQuantity=entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getQuantity()<3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }
}
