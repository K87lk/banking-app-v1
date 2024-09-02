package org.example.ui;

import org.example.service.ClientService;

import java.util.Scanner;

public class ApplicationInterface {
    public static void startApplication() {

        ClientService clientService = new ClientService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create client");
            System.out.println("2. Create account for client");
            System.out.println("3. Close account for client");
            System.out.println("4. Deposit money");
            System.out.println("5. Transfer money");
            System.out.println("6. Show all clients");
            System.out.println("7. Show all accounts");
            System.out.println("8. Exit");
            System.out.print("\n Choose the option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 :
                    clientService.createClient();
                    break;
                case 2:
                    clientService.createAccount();
                    break;
                case 3:
                    clientService.closeAccount();
                    break;
                case 4:
                    clientService.depositToAccount();
                    break;
                case 5:
                    clientService.transferBetweenAccounts();
                    break;
                case 6:
                    clientService.displayAllClients();
                    break;
                case 7:
                    clientService.displayAllAccounts();
                    break;
                case 8:
                    System.out.println("Thank you for using our application!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
