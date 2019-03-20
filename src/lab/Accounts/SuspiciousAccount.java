package lab.Accounts;

public class SuspiciousAccount extends AccountDecorator {

    SuspiciousAccount(BankAccount account) {
        super(account);
    }

}
