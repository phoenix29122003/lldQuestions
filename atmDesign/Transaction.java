package lldQuestions.atmDesign;

public abstract class Transaction {
    protected String transactionId;
    protected Account account;
    protected double amount;

    public Transaction(String transactionId,Account account,double amount){
        this.transactionId=transactionId;
        this.account=account;
        this.amount=amount;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public Account getAccount(){
        return account;
    }

    public double getAmount(){
        return amount;
    }

    public abstract void execute();
}
