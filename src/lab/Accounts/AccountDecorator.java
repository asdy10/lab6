package lab.Accounts;

import lab.Client;

public class AccountDecorator implements BankAccount {
    private static final int MAX_ALLOWED = 15000;

    private BankAccount bankAccount;

    AccountDecorator(BankAccount account) {
        this.bankAccount = account;
    }

    @Override
    public void putMoney(double amount) {
        bankAccount.putMoney(amount);
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount > MAX_ALLOWED)
            return;
        bankAccount.withdrawMoney(amount);
    }

    @Override
    public void transferMoney(double amount, BankAccount anotherAccount) {
        if (amount > MAX_ALLOWED)
            return;
        bankAccount.transferMoney(amount, anotherAccount);
    }

    @Override
    public Client getOwner() {
        return bankAccount.getOwner();
    }

}
