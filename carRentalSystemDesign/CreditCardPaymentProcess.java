package lldQuestions.carRentalSystemDesign;

public class CreditCardPaymentProcess implements PaymentProcessor {
    @Override 
    public boolean processPayment(double amount){
        return true;
    }
}
