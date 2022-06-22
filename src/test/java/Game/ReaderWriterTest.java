package Game;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderWriterTest {

    ReaderWriter writeTest = new ReaderWriter();

    @Test (expected = NullPointerException.class)
    public void write() {
        writeTest.write(5, null);
    }
}