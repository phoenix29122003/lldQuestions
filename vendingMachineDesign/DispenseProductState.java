package lldQuestions.vendingMachineDesign;

public class DispenseProductState implements VendingMachineState{
    VendingMachine vendingMachine;

    public DispenseProductState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("You have already selected the product and made payment. Please collect your product.");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("You have already selected the product and made payment. Please collect your product.");
    }

    @Override
    public void insertNote(Note note){
        System.out.println("You have already selected the product and made payment. Please collect your product.");
    }

    @Override 
    public void dispenseProduct(){
        Product product= vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product)-1);
        System.out.println("Collect your product: "+product.getProductName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override 
    public void returnChange(){
        System.out.println("Please collect the product first.");
    }
}
