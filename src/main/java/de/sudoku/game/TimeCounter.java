package de.sudoku.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeCounter extends Thread {

    Logger log = LogManager.getLogger(TimeCounter.class);
    private int count;
    private boolean isRunning;

    @Override
    public void run() {
        count = 0;
        log.debug("Timer not running");
        while (isRunning) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getStackTrace()+"Thread is not running");
            }
            count++;
        }
        log.debug("Timer running");
    }

    public int getCount() {
        return count;
    }

    public void setIsRunning(boolean isrunning) {
        this.isRunning = isrunning;
    }

}
