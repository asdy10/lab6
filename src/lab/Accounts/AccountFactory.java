package lab.Accounts;

import lab.Client;

public class AccountFactory {

    public DebitAccount getDebitAccount(double balance, Client owner) {
        return new DebitAccount(balance, owner);
    }

    public DepositAccount getDepositAccount(double balance, Client owner, double percent) {
        return new DepositAccount(balance, owner, percent);
    }

    public CreditAccount getCreditAccount(double balance, Client owner, double limit, double commission) {
        return new CreditAccount(balance, owner, limit, commission);
    }


}
