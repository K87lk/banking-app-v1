package org.example.domain;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private double balance;
    private AccountStatus accountStatus;
    private String bic;
    private Currency currency;
    private String accountHolder;

    public Account() {
    }

    public Account(String accountNumber, String bic, Currency currency, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.accountStatus = AccountStatus.OPEN;
        this.bic = bic;
        this.currency = currency;
        this.accountHolder = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account: ");
        sb.append("Account number: '").append(accountNumber).append('\'');
        sb.append("Account holder: ").append(accountHolder).append('\'');
        sb.append(", Balance: ").append(balance);
        sb.append(", Account status: ").append(accountStatus);
        sb.append(", BIC: '").append(bic).append('\'');
        sb.append(", Currency: ").append(currency);
        return sb.toString();
    }
}
