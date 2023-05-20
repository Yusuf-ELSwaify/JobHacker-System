package org.jobhacker.squared_and_cubic;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scn = new Scanner(System.in))
        {
            int lines = scn.nextInt();
            for (int i = 1; i <= lines; i++)
                System.out.println(i + " " + (i * i) + " " + (i * i * i));
        }
    }
}
