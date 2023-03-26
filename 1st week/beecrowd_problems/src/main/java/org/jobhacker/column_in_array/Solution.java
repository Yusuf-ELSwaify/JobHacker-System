package org.jobhacker.column_in_array;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int column, sum = 0;
        char op;
        double arr[][] = new double[12][12];
        try (Scanner scn = new Scanner(System.in)){
            column = scn.nextInt();
            op = scn.next().charAt(0);
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 12; j++)
                    arr[i][j] = scn.nextDouble();
        }
        for (int i = 0; i < 12; i++)
            sum += arr[i][column];
        System.out.printf("%.1f\n", (op == 'S') ? sum : (sum / 12.0));
    }
}
