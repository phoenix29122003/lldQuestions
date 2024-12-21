package lldQuestions.vendingMachineDesign;

public class VendingMachine {
    private VendingMachineState selectProductState;
    private VendingMachineState moneyCollectionState;
    private VendingMachineState dispenseProductState;
    private VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private double totalAmountCollected;
    private Product selectedProduct;
    Inventory inventory;

    public VendingMachine(){
        this.inventory=new Inventory();
        this.selectedProduct=null;
        this.totalAmountCollected=0.0;
        selectProductState=new SelectProductState(this);
        moneyCollectionState=new MoneyCollectionState(this);
        dispenseProductState=new DispenseProductState(this);
        returnChangeState=new ReturnChangeState(this);
        currentState=selectProductState;
    }

    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note){
        currentState.insertNote(note);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public void returnChange(){
        currentState.returnChange();
    }

    VendingMachineState getSelectProductState(){
        return selectProductState;
    }

    VendingMachineState getMoneyCollectionState(){
        return moneyCollectionState;
    }

    VendingMachineState getDispenseProductState(){
        return dispenseProductState;
    }

    VendingMachineState getReturnChangeState(){
        return returnChangeState;
    }

    void setState(VendingMachineState vendingMachineState){
        currentState=vendingMachineState;
    }

    Product getSelectedProduct(){
        return selectedProduct;
    }

    void setSelectedProduct(Product product){
        selectedProduct=product;
    }

    void resetSelectedProduct(){
        selectedProduct=null;
    }

    double getTotalPayment(){
        return totalAmountCollected;
    }

    void addCoin(Coin coin){
        totalAmountCollected+=coin.getValue();
    }

    void addNote(Note note){
        totalAmountCollected+=note.getValue();
    }

    void resetPayment(){
        totalAmountCollected=0.0;
    }
}
