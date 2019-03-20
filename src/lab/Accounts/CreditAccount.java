package lab.Accounts;

import lab.Client;

public class CreditAccount implements BankAccount {

    private static final int MAX_LIMIT = 15000;

    private double balance;
    //    private long accountNumber;
    private Client owner;
    private boolean isLimited = false;
    private double limit;
    private double comission;

    public CreditAccount(double balance, /*long accountNumber,*/ Client owner, double limit, double comission) {
        this.balance = balance;
//        this.accountNumber = accountNumber;
        this.owner = owner;
        this.limit = limit;
        this.comission = comission;
        if (owner.hasFewInfo())
            this.isLimited = true;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public Client getOwner() {
        return owner;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public double getLimit() {
        return limit;
    }

    public double getComission() {
        return comission;
    }

    private boolean isCorrectTransaction(double amount) {
        if (isLimited && amount > limit)
            return false;
        if (this.balance - amount < limit)
            return false;
        return true;
    }

    @Override
    public void putMoney(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (isCorrectTransaction(amount))
            this.balance -= amount;
    }

    @Override
    public void transferMoney(double amount, BankAccount anotherAccount) {
        if (isCorrectTransaction(amount)) {
            this.balance -= amount;
            anotherAccount.putMoney(amount);
        }
    }


}