import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private String printedMessage      = "";
    private List<String> inputMessages = new ArrayList<String>();

    public void setInput(String message) {
        inputMessages.add(message);
    }

    public boolean readMethodWasCalled() {
        return wasReadMethodCalled;
    }

    public String read() {
        wasReadMethodCalled = true;
        return inputMessages.remove(0);
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

    public void setInputs(String ... messages) {
        inputMessages.addAll(Arrays.asList(messages));
    }
}
