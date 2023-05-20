package org.jobhacker.distance_between_two_points;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in))
        {
            Double x1 = scn.nextDouble();
            Double y1 = scn.nextDouble();
            Double x2 = scn.nextDouble();
            Double y2 = scn.nextDouble();

            Double x2_x1_2 = Math.pow(x2 - x1, 2);
            Double y2_y1_2 = Math.pow(y2 - y1, 2);

            System.out.printf("%.4f\n", Math.sqrt(x2_x1_2 + y2_y1_2));
        }
    }
}
