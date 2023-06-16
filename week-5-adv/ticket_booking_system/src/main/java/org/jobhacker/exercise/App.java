package org.jobhacker.exercise;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App 
{
    public static void main( String[] args )
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        String[] names = new String[]{"Liberty Donnelly",
                "Declan Mcconnell",
                "Rose Pacheco",
                "Philip Golden",
                "Elissa Chapman",
                "Jayson Ward",
                "Sadie Russo",
                "Logan Lawrence",
                "Remi Mathews",
                "Valentina Chase",
                "Osman Andrews",
                "Wade Vaughan",
                "Angus Stuart",
                "Jessie Bauer",
                "Nancy Atkins"};
        Event concertEvent = new Event("live concert", 10);
        Event workshopEvent = new Event("workshop", 14);

        Arrays.stream(names).parallel().forEach((name)->executor.submit(() -> workshopEvent.bookTicket(name)));

        for (final String name:names) {
            //new Thread(() -> event.bookTicket(name)).start();
            executor.submit(() -> concertEvent.bookTicket(name));
        }
        executor.shutdown();

    }
}
