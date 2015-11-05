import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameConsoleTest {

    @Test
    public void readMethodReadsAString() {
        InputStream in = new ByteArrayInputStream("Hello".getBytes());
        GameConsole gameConsole = new GameConsole(in, null);

        assertEquals("Hello", gameConsole.read());
    }

    @Test
    public void writeMethodWritesAString() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        GameConsole echoConsole = new GameConsole(null, out);
        echoConsole.write("Hello");

        assertEquals("Hello\n", outputStream.toString());
    }
}
