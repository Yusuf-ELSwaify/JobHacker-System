package job_hacker.tasks.models;

import java.time.LocalTime;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        start();
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

}
