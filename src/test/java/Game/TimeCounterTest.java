package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCounterTest {
    TimeCounter timeTest = new TimeCounter();
    //testet bisher nur ob der Timer aus ist
    @Test
    void getCount() {
        //timeTest.setIsRunning(true);
        timeTest.run();
        //timeTest.setIsRunning(false);
        assertEquals(0, timeTest.getCount(),"Timer is running" );

    }
}