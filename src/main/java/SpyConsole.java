public class SpyConsole {

    private boolean wasWriteMethodCalled = false;
    private String printedMessage = "";

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
