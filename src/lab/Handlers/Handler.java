package lab.Handlers;

import lab.Client;

public abstract class Handler {

    public abstract void handleRequest(Request request);
    public Handler nextHandler;
    public Handler getNextHandler() {
        return nextHandler;
    }
    public void setNextHandler(Handler next) {
        nextHandler = next;
    }

}
