package org.jobhacker.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    public int num;
    public App(int num)
    {
        this.num = num;
    }

    public static void main( String[] args )
    {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i+=2 )
        {
            executor.submit(new App(i));
            executor.submit(new App(i + 1));
        }
        executor.shutdown();
    }

    public void run() {
        synchronized (App.class) {
            System.out.print(num + ": ");
            System.out.print(num % 2 == 0 ? "Even" : "Odd");
            System.out.println(" - " + Thread.currentThread().getName());
        }
    }
}
