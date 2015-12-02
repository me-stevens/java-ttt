package com.mael.ttt;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameConsole implements Console {

    private final InputStream in;
    private final PrintStream out;

    public GameConsole(InputStream in, PrintStream out) {
        this.in  = in;
        this.out = out;
    }

    public String read() {
        return new Scanner(in).nextLine();
    }

    public void write(String message) {
        out.print(message);
    }
}
