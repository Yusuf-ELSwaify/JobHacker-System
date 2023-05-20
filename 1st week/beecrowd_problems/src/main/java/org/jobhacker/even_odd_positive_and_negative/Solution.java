package org.jobhacker.even_odd_positive_and_negative;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int even = 0, odd = 0, negative = 0, postive = 0;
        try (Scanner scn = new Scanner(System.in))
        {
            for (int i = 0; i < 5; i++)
            {
                int in = scn.nextInt();
                if ((in & 1) == 1)
                    ++odd;
                else
                    ++even;
                if (in > 0)
                    ++postive;
                else if (in != 0)
                    ++negative;
            }
            System.out.println(even +" valor(es) par(es)");
            System.out.println(odd +" valor(es) impar(es)");
            System.out.println(postive +" valor(es) positivo(s)");
            System.out.println(negative +" valor(es) negativo(s)");
        }
    }
}
