package Game;

public class TimeCounter extends Thread {
    private int count;
    private boolean isrunning;

    @Override
    public void run() {
        count = 0;
        while (isrunning) {
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

    public void setIsrunning(boolean isrunning) {
        this.isrunning = isrunning;
    }

    public void update() {
        Thread.activeCount();
    }

}
