package org.jobhacker.highest_and_position;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int max = -1, max_pos = 0, i = 1;
        try (Scanner scn = new Scanner(System.in))
        {
            while (scn.hasNext())
            {
                int in = scn.nextInt();
                if (in > max)
                {
                    max = in;
                    max_pos = i;
                }
                ++i;
            }
            System.out.println(max);
            System.out.println(max_pos);
        }

    }
}
