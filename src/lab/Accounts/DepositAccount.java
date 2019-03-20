package lab.Accounts;

import lab.Client;

public class DepositAccount implements BankAccount {
    private double balance;
    private Client owner;
    private boolean isLimited = false;
    private double percent;

    public DepositAccount(double amount, Client owner, double percent) {
        this.balance = amount;
        this.owner = owner;
        this.percent = percent;

        if (owner.hasFewInfo())
            isLimited = true;
    }

    public double getBalance() {
        return balance;
    }

//    public long getAccountNumber() {
//        return accountNumber;
//    }

    public Client getOwner() {
        return owner;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public double getPercent() {
        return percent;
    }

    private boolean correctTransaction(double amount) {
        if (isLimited && amount > 15000)
            return false;
        if (this.balance < amount)
            return false;
        return true;
    }

    @Override
    public void putMoney(double amount) {
        this.balance = amount + amount * percent;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (correctTransaction(amount))
            this.balance -= amount;
    }

    @Override
    public void transferMoney(double amount, BankAccount anotherAccount) {
        if (anotherAccount.getOwner() != this.getOwner())
            return;
        if (correctTransaction(amount)) {
            this.balance -= amount;
            anotherAccount.putMoney(amount);
        }
    }
}
