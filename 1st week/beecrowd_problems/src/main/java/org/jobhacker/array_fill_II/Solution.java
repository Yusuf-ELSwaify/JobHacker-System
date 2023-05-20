package org.jobhacker.array_fill_II;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int current = 0, index = 0, base;
        try (Scanner scn = new Scanner(System.in)){
            base = scn.nextInt();
        }
        while (index < 1000)
        {
            if (current == base)
                current = 0;
            System.out.println("N[" + (index++) + "] = " + (current++));
        }
    }
}
