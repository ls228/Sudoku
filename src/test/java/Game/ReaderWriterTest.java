package Game;

import org.junit.Test;

public class ReaderWriterTest {

    ReaderWriter writeTest = new ReaderWriter();
    //negative testing
    @Test (expected = NullPointerException.class)
    public void write() {
            writeTest.write(5, null);
    }
}