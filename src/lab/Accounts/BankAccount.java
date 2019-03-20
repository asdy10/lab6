package lab.Accounts;

import lab.Client;

public interface BankAccount {
    void putMoney     (double amount);
    void withdrawMoney(double amount);
    void transferMoney(double amount, BankAccount anotherAccount);
    Client getOwner();
}
