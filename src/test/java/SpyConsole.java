import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private String printedMessage        = "";
    private String firstPrintedMessage   = "";
    private String lastPrintedMessage    = "";
    private List<String> inputMessages   = new ArrayList<String>();
    private int timesReadWasCalled       = 0;
    private int timesWriteWasCalled      = 0;

    public void setInput(String message) {
        inputMessages.add(message);
    }

    public void setInputs(String ... messages) {
        inputMessages.addAll(Arrays.asList(messages));
    }

    public boolean readMethodWasCalled() {
        return wasReadMethodCalled;
    }

    public String read() {
        wasReadMethodCalled = true;
        timesReadWasCalled++;
        return inputMessages.remove(0);
    }

    public void write(String message) {
        wasWriteMethodCalled = true;
        timesWriteWasCalled++;

        printedMessage      += message;
        lastPrintedMessage   = message;

        if (timesWriteWasCalled == 1) {
            firstPrintedMessage = message;
        }
    }

    public boolean writeMethodWasCalled() {
        return wasWriteMethodCalled;
    }

    public String printedMessage() {
        return printedMessage;
    }

    public int timesReadWasCalled() {
        return timesReadWasCalled;
    }

    public String firstPrintedMessage() {
        return firstPrintedMessage;
    }

    public String lastPrintedMessage() {
        return lastPrintedMessage;
    }
}
