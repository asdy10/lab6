package lab.Accounts;

import lab.Client;

public class DebitAccount implements BankAccount {
    private double balance;
    private Client owner;
    private boolean isLimited = false;

    public DebitAccount(double amount, Client owner) {

        this.balance = amount;
        this.owner = owner;
        if (owner.hasFewInfo())
            isLimited = true;
    }

    public double getBalance() {
        return balance;
    }

    public Client getOwner() {
        return owner;
    }

    public boolean isLimited() {
        return isLimited;
    }


    @Override
    public void putMoney(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (isLimited && amount > 15000)
            return;
        if (this.balance < amount)
            return;
        this.balance -= amount;
    }

    @Override
    public void transferMoney(double amount, BankAccount anotherAccount) {
        withdrawMoney(amount);
        anotherAccount.putMoney(amount);
    }
}
