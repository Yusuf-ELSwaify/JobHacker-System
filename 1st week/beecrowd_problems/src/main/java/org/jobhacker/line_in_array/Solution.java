package org.jobhacker.line_in_array;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int row, sum = 0;
        char op;
        double arr[][] = new double[12][12];
        try (Scanner scn = new Scanner(System.in)){
            row = scn.nextInt();
            op = scn.next().charAt(0);
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 12; j++)
                    arr[i][j] = scn.nextDouble();
        }
        for (int j = 0; j < 12; j++)
            sum += arr[row][j];
        System.out.println((op == 'S') ? sum : (sum / 12.0));
    }
}
