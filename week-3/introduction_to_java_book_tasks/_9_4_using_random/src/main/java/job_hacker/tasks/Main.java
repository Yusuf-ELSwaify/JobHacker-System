package job_hacker.tasks;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(1000);
        for (int i = 0;; i++){
            System.out.print(rand.nextInt(100));
            if (i == 50)
                break;
            System.out.print(", ");
        }
        System.out.println();
    }
}