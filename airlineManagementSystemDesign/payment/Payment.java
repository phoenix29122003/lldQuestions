package lldQuestions.airlineManagementSystemDesign.payment;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amount;
    private PaymentStatus status;

    public Payment(String paymentId,String paymentMethod,double amount,PaymentStatus status){
        this.paymentId=paymentId;
        this.paymentMethod=paymentMethod;
        this.amount=amount;
        this.status=PaymentStatus.PENDING;
    }

    public void processPayment(){
        this.status=PaymentStatus.COMPLETED;
    }
}
