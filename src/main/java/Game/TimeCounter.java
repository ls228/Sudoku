package Game;

import Controller.Controller;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TimeCounter extends Thread {

    private static final Logger log = LogManager.getLogger(TimeCounter.class);
    private int count;
    private boolean isRunning;

    @Override
    public void run() {
        count = 0;
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            log.info("Time: " + count);
        }
    }

    public int getCount() {
        return count;
    }

    public void setIsRunning(boolean isrunning) {
        this.isRunning = isrunning;
    }

}
