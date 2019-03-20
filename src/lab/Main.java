package lab;

import lab.Accounts.AccountFactory;
import lab.Accounts.BankAccount;
import lab.Accounts.DepositAccount;

public class Main {

    public static void main(String[] args) {
        Client client = Client.Builder("Alexey", "Ermolaev")
                .withPassportNumber(88888888)
                .build();

        System.out.println(client.toString());

        BankAccount bankAccount = new AccountFactory().getDepositAccount(11000, client, 0.05);
        System.out.println(((DepositAccount) bankAccount).getPercent());

    }
}

