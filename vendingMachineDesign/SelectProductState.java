package lldQuestions.vendingMachineDesign;

public class SelectProductState implements VendingMachineState{
    VendingMachine vendingMachine;
    public SelectProductState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectProduct(Product product){
        if(vendingMachine.inventory.isAvailable(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getMoneyCollectionState());
            System.out.println("You selected the product: " + product.getProductName());
        }
        else{
            System.out.println("Product not available.");
        }
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Please select a product first");
    }

    @Override
    public void insertNote(Note note){
        System.out.println("Please select a product first");
    }

    @Override 
    public void dispenseProduct(){
        System.out.println("Please select a product first.");
    }

    @Override 
    public void returnChange(){
        System.out.println("Please select a product first.");
    }
}
