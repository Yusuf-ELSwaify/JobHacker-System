package job_hacker.tasks;

import job_hacker.tasks.models.Location;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");
        int rowNum = scanner.nextInt();
        int colNum = scanner.nextInt();
        double[][] a = new double[rowNum][colNum];
        System.out.println("Enter the array: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        Location location = Location.locateLargest(a);
        System.out.println(location);
    }
}