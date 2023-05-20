package org.jobhacker.average_2;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int a_weight = 2, b_weight = 3, c_weight = 5;
        try (Scanner scn = new Scanner(System.in))
        {
            Double a = scn.nextDouble();
            Double b = scn.nextDouble();
            Double c = scn.nextDouble();
            System.out.printf("MEDIA = %.1f\n",
                    (((a * a_weight) + (b * b_weight) + (c * c_weight))
                            / (a_weight + b_weight + c_weight)));
        }

    }

}
