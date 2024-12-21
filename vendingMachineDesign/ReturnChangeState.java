package lldQuestions.vendingMachineDesign;

public class ReturnChangeState implements VendingMachineState{
    VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectProduct(Product product){
        System.out.println(
                "No change to dispense right now.");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("No change to dispense right now.");
    }

    @Override
    public void insertNote(Note note){
        System.out.println("No change to dispense right now.");
    }

    @Override 
    public void dispenseProduct(){
        System.out.println("No change to dispense right now.");
    }

    @Override 
    public void returnChange(){
        double change=vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getProductPrice();
        if(change>0){
            System.out.println("Collect your change: "+change);
        }
        else{
            System.out.println("No change to collect");
        }
        vendingMachine.setState(vendingMachine.getSelectProductState());
        vendingMachine.resetSelectedProduct();
        vendingMachine.resetPayment();
    }
}
