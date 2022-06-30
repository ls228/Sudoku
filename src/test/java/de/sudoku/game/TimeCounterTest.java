package de.sudoku.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeCounterTest {
    TimeCounter timeTest = new TimeCounter();

    @Test
    void getCount() {
        timeTest.run();
        assertEquals(0, timeTest.getCount(), "Timer is sleeping");
    }
}