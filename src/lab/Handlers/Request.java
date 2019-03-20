package lab.Handlers;

import lab.Client;

public abstract class Request {
    private int correctness;
    public Client owner;

    Request(Client owner) {
        this.owner = owner;
    }

    public void setCorrectness(int correct) {
        this.correctness = correct;
    }

    public int getCorrectness() {
        return correctness;
    }

    public Client getOwner() {
        return owner;
    }

    public abstract void executeRequest();
}
