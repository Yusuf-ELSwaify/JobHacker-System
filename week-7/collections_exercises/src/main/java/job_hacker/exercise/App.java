package job_hacker.exercise;

import job_hacker.exercise.services.GeneralService;
import job_hacker.exercise.services.HashSetService;
import job_hacker.exercise.services.LinkedHashSetService;
import job_hacker.exercise.services.TreeMapService;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        try (Scanner sc = new Scanner(System.in)) {
            // you can choose the service according to the task
            GeneralService service = getTheService(sc);
            System.out.println("Enter number of test cases");
            int testNum = sc.nextInt();

            while (testNum > 0) {
                System.out.println("Enter number of queries");
                int queryNum = sc.nextInt();
                while (queryNum > 0) {
                    char c = sc.next().charAt(0);
                    service.queryExecutor(c);
                    queryNum--;
                }
                testNum--;
                service.clear();
            }
        }
    }

    private static GeneralService getTheService(Scanner sc) {
        System.out.println("Choose the task:\n1-LinkedHashSet 2-TreeMap 3-HashSet");
        int taskNum = sc.nextInt();
        switch (taskNum){
            case 1:
                return new LinkedHashSetService(sc);
            case 2:
                return new TreeMapService(sc);
            case 3:
                return new HashSetService(sc);
            default:
                throw new IllegalArgumentException();
        }
    }

}
