package lldQuestions.atmDesign;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private BankingService bankingService;
    private CashDespenser cashDespenser;
    private static final AtomicLong transactionCounter = new AtomicLong(0);

    public ATM(BankingService bankingService,CashDespenser cashDespenser){
        this.bankingService=bankingService;
        this.cashDespenser=cashDespenser;
    }

    public void authenticateUser(Card card){
        System.out.println("User has been authenticated.");
    }

    public double checkBalance(String accountNumber){
        Account account=bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdrawCash(String accountNumber,double amount){
        Account account=bankingService.getAccount(accountNumber);
        if(account.getBalance()<amount){
            System.out.println("Sorry, Insufficient Balance");
            return;
        }
        Transaction transaction=new WithdrawTransaction(generateTransactionId(),account,amount);
        bankingService.processTransaction(transaction);
        cashDespenser.despenseCash((int)amount);
    }

    public void depositCash(String accountNumber,double amount){
        Account account=bankingService.getAccount(accountNumber);
        Transaction transaction=new DepositTransaction(generateTransactionId(),account,amount);
        bankingService.processTransaction(transaction);
        cashDespenser.depositCash((int)amount);
    }

    private String generateTransactionId() {
        long transactionNumber = transactionCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + String.format("%010d", transactionNumber);
    }
}
