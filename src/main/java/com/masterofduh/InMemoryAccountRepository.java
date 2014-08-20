package com.masterofduh;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements IAccountRepository {
    private Map<String, Double> accounts;

    public InMemoryAccountRepository(Map<String, Double> accounts) {
        this.accounts = new HashMap<>(accounts);
    }

    @Override
    public double debit(String accountId, double amount) {
        double balance = accounts.get(accountId);
        balance -= amount;
        accounts.put(accountId, balance);
        return balance;
    }

    @Override
    public double credit(String accountId, double amount) {
        double balance = accounts.get(accountId);
        balance += amount;
        accounts.put(accountId, balance);
        return balance;
    }

    @Override
    public double balance(String accountId) {
        return accounts.get(accountId);
    }

}
