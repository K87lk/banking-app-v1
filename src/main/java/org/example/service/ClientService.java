package org.example.service;

import org.example.domain.Account;
import org.example.domain.AccountStatus;
import org.example.domain.Client;
import org.example.domain.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    private List<Client> clients = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createClient() {

        Client client = new Client();

        System.out.println("Enter your name: ");
        String fullName = scanner.nextLine();
        client.setFullName(fullName);
        System.out.println("Enter your phone: ");
        String phoneNumber = scanner.nextLine();
        client.setPhoneNumber(phoneNumber);

        for (Client client1 : clients) {
            if (client1.getPhoneNumber() != null && client1.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Number already taken. Try another one.");
                String correctNumber = scanner.nextLine();
                client.setPhoneNumber(correctNumber);
            } else {
                client.setPhoneNumber(phoneNumber);
            }
        }
        System.out.println("Enter your inn: ");
        String inn = scanner.nextLine();
        client.setInn(inn);
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
        client.setAddress(address);

        clients.add(client);
        System.out.println("\nClient created successfully!!!\n");
    }


    private Client findClient(String fullName) {
        if (clients != null) {
            for (Client client : clients) {
                if (client.getFullName() != null && client.getFullName().equals(fullName)) {
                    return client;
                } else {
                    System.out.println("Client not found");
                    return null;
                }
            }
        }
        return null;
    }

    public void createAccount() {

        Account account = new Account();

        System.out.println("Enter your name");
        String accountHolder = scanner.nextLine();
        account.setAccountHolder(accountHolder);
        Client client = findClient(accountHolder);

        if (client != null && client.getFullName().equals(accountHolder)) {
            System.out.println("Enter account number: ");
            String accountNumber = scanner.nextLine();
            account.setAccountNumber(accountNumber);
            System.out.println("Enter BIC: ");
            String bic = scanner.nextLine();
            account.setBic(bic);
            System.out.println("Enter currency(RUB, EUR, USD): ");
            String currency = scanner.nextLine();
            account.setCurrency(Currency.valueOf(currency));

            account.setAccountStatus(AccountStatus.OPEN);

            accounts.add(account);
            client.setAccounts(accounts);
            System.out.println("\nNew account created for " + accountHolder + " with Account Number: " + accountNumber);
        } else {
            System.out.println("Client not found. Cannot create account");
        }
    }

    public void closeAccount() {
        System.out.println("Enter your name: ");
        String accountHolder = scanner.nextLine();

        Client client = findClient(accountHolder);
        displayOpenAccounts(accountHolder);

        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (client != null && account != null && account.getAccountHolder().equals(accountHolder)) {
            accounts.removeIf(a -> a.getAccountHolder().equals(accountHolder));
            client.getAccounts().removeIf(c -> c.getAccountHolder().equals(accountHolder));
            System.out.println("\nAccount closed successfully!\n");
        } else {
            System.out.println("Ether clients or accounts are not found!");
        }
    }

    private Account findAccount(String accountNumber) {
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    public void depositToAccount() {
        System.out.println("Enter your name: ");
        String accountHolder = scanner.nextLine();

        displayOpenAccounts(accountHolder);

        System.out.println("Enter account number to deposit");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Enter the amount of money to deposit: ");
            double amount = scanner.nextDouble();
            if(amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Money successfully deposited!");
            } else {
                System.out.println("Number should be positive! Try again");
                double correctAmount = scanner.nextDouble();
                account.setBalance(account.getBalance() + correctAmount);
                System.out.println("Money successfully deposited!");
            }
        } else {
            System.out.println("Account does not exist!");
        }
    }

    public void transferBetweenAccounts() {
        System.out.println("Enter your name: ");
        String accountHolder = scanner.nextLine();

        System.out.println("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        Account fromAccount = findAccount(fromAccountNumber);

        System.out.println("Enter account number to transfer: ");
        String toAccountNumber = scanner.nextLine();
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.getAccountHolder().equals(accountHolder)) {
            if (fromAccount.getBalance() > 0) {
                System.out.println("Enter the amount of money to transfer: ");
                double amount = scanner.nextDouble();
                if (amount < fromAccount.getBalance()) {
                    fromAccount.setBalance(fromAccount.getBalance() - amount);
                    toAccount.setBalance(toAccount.getBalance() + amount);
                    System.out.println("Money transferred successfully!");
                } else {
                    System.out.println("Amount is bigger than balance. Try smaller amount");
                    double correctAmount = scanner.nextDouble();
                    fromAccount.setBalance(fromAccount.getBalance() - correctAmount);
                    toAccount.setBalance(toAccount.getBalance() + correctAmount);
                    System.out.println("Money transferred successfully!");
                }
            } else {
                System.out.println("Insufficient balance. Cannot transfer!");
            }

        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void displayAllAccounts() {
        if (accounts != null) {
            accounts.forEach(account -> {
                System.out.println(account.toString());
            });
        } else {
            System.out.println("Accounts not found!");
        }
    }

    public void displayOpenAccounts(String fullName) {
        Client client = findClient(fullName);
        if (client != null) {
            clients.forEach(Client::getOpenAccounts);
        }

    }

    public void displayAllClients() {
        if (clients != null) {
            clients.forEach(client -> {
                System.out.println(client.toString());
            });
        } else {
            System.out.println("Clients not found!");
        }
    }
}
