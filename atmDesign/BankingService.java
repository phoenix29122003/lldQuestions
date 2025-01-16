package lldQuestions.atmDesign;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    private Map<String,Account>accounts=new HashMap<>();
    
    public void createAccount(String accountNumber,double balance){
        accounts.put(accountNumber,new Account(accountNumber, balance));
    }

    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction){
        transaction.execute();
    }
}
