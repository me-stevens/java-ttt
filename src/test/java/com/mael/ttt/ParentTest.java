package com.mael.ttt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParentTest {

    public Board board;

    public ParentTest(int boardSize) {
        board = new Board(boardSize);
    }

    @Parameterized.Parameters
    public static Collection dataSetup() {
        return Arrays.asList(new Object[][]{{3}, {4}});
    }

    @Test
    public void dummy() {
        // Dummy test needed for JUnit to compile
    }
}