package org.jobhacker.extremely_basic;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in))
        {
            int a = scn.nextInt();
            int b = scn.nextInt();
            System.out.println("X = " + (a + b));
        }
    }
}
