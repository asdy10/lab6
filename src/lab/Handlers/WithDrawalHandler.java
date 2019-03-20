package lab.Handlers;

public class WithDrawalHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getCorrectness() == 1)   //  everything is good
            request.executeRequest();
    }
}
