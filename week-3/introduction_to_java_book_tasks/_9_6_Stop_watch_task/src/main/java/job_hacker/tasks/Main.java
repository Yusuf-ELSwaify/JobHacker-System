package job_hacker.tasks;

import job_hacker.tasks.models.StopWatch;
import job_hacker.tasks.templatemethod.ArraySelectionSort;
import job_hacker.tasks.templatemethod.ArraySort;

public class Main implements Runnable{
    StopWatch stopWatch;

    public void run(){
        stopWatch = new StopWatch();
        ArraySort arraySort = new ArraySelectionSort();
        arraySort.fillSortArray();
        stopWatch.stop();
        System.out.printf("filling and sorting array took : %d millisecond\n", stopWatch.getElapsedTime());
    }

    public static void main(String[] args) {
        Main m = new Main();
        Thread t1 =new Thread(m);
        t1.start();
    }
}