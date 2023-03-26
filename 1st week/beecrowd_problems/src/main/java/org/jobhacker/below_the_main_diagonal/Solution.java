package org.jobhacker.below_the_main_diagonal;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int column, count = 0;
        double sum = 0;
        char op;
        double arr[][] = new double[12][12];
        try (Scanner scn = new Scanner(System.in)){
            op = scn.next().charAt(0);
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 12; j++)
                    arr[i][j] = scn.nextDouble();
        }
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < i; j++){
                sum += arr[i][j];
                count++;
            }
        System.out.printf("%.1f\n", (op == 'S') ? sum : (sum / count));
    }
}
