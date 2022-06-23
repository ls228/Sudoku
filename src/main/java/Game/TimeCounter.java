package Game;

public class TimeCounter extends Thread {
    private int count;
    private boolean isRunning;

    @Override
    public void run() {
        count = 0;
        while (isRunning) {
            try {
                Thread.sleep(1000);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void setIsRunning(boolean isrunning) {
        this.isRunning = isrunning;
    }

    public void update() {

        Thread.activeCount();
    }

}
