package lldQuestions.vendingMachineDesign;

public class MoneyCollectionState implements VendingMachineState{
    VendingMachine vendingMachine;
    public MoneyCollectionState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("You have already selected the product. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin){
        vendingMachine.addCoin(coin);
        System.out.println("You inserted a coin: "+coin);
        if(vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getProductPrice()>=0){
            vendingMachine.setState(vendingMachine.getDispenseProductState());
        }
    }

    @Override
    public void insertNote(Note note){
        vendingMachine.addNote(note);
        System.out.println("You inserted a note: "+note);
        if(vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getProductPrice()>=0){
            vendingMachine.setState(vendingMachine.getDispenseProductState());
        }
    }

    @Override 
    public void dispenseProduct(){
        System.out.println("Please make the payment first.");
    }

    @Override 
    public void returnChange(){
        System.out.println("Please make the payment first.");
    }


}
