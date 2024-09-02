package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String fullName;
    private String phoneNumber;
    private String inn;
    private String address;
    private List<Account> accounts;

    public Client() {
    }

    public Client(String fullName, String phoneNumber, String inn, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.address = address;
        accounts = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void getOpenAccounts() {
        if (accounts != null) {
            accounts.stream()
                    .filter(account -> account.getAccountStatus().equals(AccountStatus.OPEN))
                    .forEach(System.out::println);
        } else {
            System.out.println("No open accounts found!");
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client: ");
        sb.append("Full name: '").append(fullName).append('\'');
        sb.append(", Phone number: '").append(phoneNumber).append('\'');
        sb.append(", INN: '").append(inn).append('\'');
        sb.append(", Address: '").append(address).append('\'');
        sb.append("\n");
        return sb.toString();
    }
}
