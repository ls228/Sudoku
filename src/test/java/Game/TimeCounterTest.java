package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCounterTest {
    TimeCounter timeTest = new TimeCounter();
    //funktioniert noch nicht
    @Test
    void getCount() {
        timeTest.setIsRunning(true);
        timeTest.run();
        timeTest.setIsRunning(false);
        assertEquals(3, timeTest.getCount(),"Timer is running" );

    }
}