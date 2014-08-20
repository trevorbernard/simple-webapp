package com.masterofduh;

import java.util.HashMap;

public class Main {
    public static void main(String [] args) {
        HashMap<String, Double> accounts = new HashMap<>();
        accounts.put("trevorbernard", 100.0);
        IAccountRepository repo = new InMemoryAccountRepository(accounts);
        // An alternate implementation might be MySQLAccountRepository repo ....
        IBankService service = new BankServiceImpl(repo);
        
        System.out.println("Trevor's accont balance: " + service.getAccountBalance("trevorbernard"));
    }
}
