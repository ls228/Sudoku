package Game;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderWriterTest {
    ReaderWriter readWrite = new ReaderWriter();

    /*@Test
    void removeEntries() {

        try{
            readWrite.removeEntries();
        }catch (Exception e){
            throw new RuntimeException();
        }
        assertEquals(1, readWrite.read(), "No entries");
    }

    @Test
    void write() {
        List<String> entries = new ArrayList<>();
        try{
            readWrite.write(1);
        }catch (Exception e){
            throw new RuntimeException();
        }
        assertEquals(entries.add("1"), readWrite.read(), "Existing entries");
    }*/

    @Test
    void read() {
    }


}