package org.jobhacker.area_of_a_circle;

import java.io.IOException;
import java.util.Scanner;
public class Solution {
    static final double pi = 3.14159;
    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in))
        {
            Double r = scn.nextDouble();
            System.out.printf("A=%.4f\n",(pi * r * r));
        }
    }
}
