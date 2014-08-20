package com.masterofduh;

public interface IAccountRepository {
    double debit(String accountId, double amount);
    double credit(String accountId, double amount);
    double balance(String accountId);
}
