package org.jobhacker.multiples;

import java.io.IOException;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in))
        {
            int a = scn.nextInt();
            int b = scn.nextInt();
            if (a < b)
                a = (a + b) - (b = a);
            System.out.printf("%s\n",  (a % b) == 0 ? "Sao Multiplos" : "Nao sao Multiplos");
        }
    }
}
