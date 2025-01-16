package lldQuestions.atmDesign;

public class CashDespenser {
    private int cashAvailable;

    public CashDespenser(int amount){
        this.cashAvailable=amount;
    }

    public void despenseCash(int amount){
        if(cashAvailable<amount){
            System.out.println("Insufficient cash in the ATM.");
        }
        else{
            cashAvailable -= amount;
            System.out.println("Please collect your despensed cash: "+amount);
        }
    }

    public void depositCash(int amount){
        cashAvailable += amount;
    }
}
