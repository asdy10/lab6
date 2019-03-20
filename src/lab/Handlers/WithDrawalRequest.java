package lab.Handlers;

import lab.Client;

public class WithDrawalRequest extends Request {
    private final double amount;

    WithDrawalRequest(Client owner, double amount) {
        super(owner);
        this.amount = amount;
    }

    @Override
    public void executeRequest() {
        owner.withdraw(amount);
    }
}
