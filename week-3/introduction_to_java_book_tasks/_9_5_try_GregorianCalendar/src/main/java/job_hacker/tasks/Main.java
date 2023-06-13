package job_hacker.tasks;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        System.out.printf("Current year = %d\n", gc.get(GregorianCalendar.YEAR));
        System.out.printf("Current month = %d\n", gc.get(GregorianCalendar.MONTH));
        System.out.printf("Current day = %d\n", gc.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println("_______________________");
        gc.setTimeInMillis(1234567898765L);
        System.out.printf("Year = %d\n", gc.get(GregorianCalendar.YEAR));
        System.out.printf("Month = %d\n", gc.get(GregorianCalendar.MONTH));
        System.out.printf("Day = %d\n", gc.get(GregorianCalendar.DAY_OF_MONTH));
    }
}