package de.sudoku.game;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderWriterTest {

    ReaderWriter readWrite = new ReaderWriter();

    //negative testing
    @Test(expected = NullPointerException.class)
    public void write() {
        readWrite.write(5, null);
    }

    @Test
    public void read() {
        readWrite.removeEntries("counter.txt");
        readWrite.write(1, "counter.txt");

        try {
            assertEquals(1, readWrite.read("counter.txt").size(), "is equal");
        } catch (Exception e) {
            throw new RuntimeException();
        }
        readWrite.write(1, "counter.txt");
        try {
            assertEquals(2, readWrite.read("counter.txt").size(), "is equal");
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}