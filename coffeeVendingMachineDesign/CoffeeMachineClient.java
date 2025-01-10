package lldQuestions.coffeeVendingMachineDesign;

public class CoffeeMachineClient {
    public static void main(String args[]){
        CoffeeMachine coffeeMachine=new CoffeeMachine();

        coffeeMachine.displayMenu();

        Coffee espresso = coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispenseCoffee(espresso, new Payment(3.0));

        Coffee cappuccino = coffeeMachine.selectCoffee("Cappuccino");
        coffeeMachine.dispenseCoffee(cappuccino, new Payment(3.5));


        Coffee latte = coffeeMachine.selectCoffee("Latte");
        coffeeMachine.dispenseCoffee(latte, new Payment(4.0));
    }
}
