package com.masterofduh;

public class BankServiceImpl implements IBankService {

    private IAccountRepository repo;

    public BankServiceImpl(IAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public double getAccountBalance(String accountId) {
        return repo.balance(accountId);
    }

}
