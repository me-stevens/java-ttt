public class SpyConsole {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private String inputMessage   = "";
    private String printedMessage = "";

    public void setInput(String message) {
        inputMessage = message;
    }

    public boolean readMethodWasCalled() {
        return wasReadMethodCalled;
    }

    public String read() {
        wasReadMethodCalled = true;
        return inputMessage;
    }

    public void write(String message) {
        wasWriteMethodCalled = true;
        printedMessage      += message;
    }

    public boolean writeMethodWasCalled() {
        return wasWriteMethodCalled;
    }

    public String printedMessage() {
        return printedMessage;
    }
}
