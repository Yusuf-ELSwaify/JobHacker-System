package org.jobhacker.array_change_I;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static void reverse(int a[], int n)
    {
        for (int i = 0; i < n / 2; i++)
            a[i] ^= a[n - i - 1] ^ (a[n - i - 1] = a[i]);

          /*  in simple way
              a[i] ^= a[n - i - 1];
              a[n - i - 1] ^= a[i];
              a[i] ^= a[n - i - 1];
          */
    }
    public static void main(String[] args) throws IOException {
        int[] arr = new int[20];
        int n = 0;
        try (Scanner scn = new Scanner(System.in))
        {
            while (scn.hasNext())
                arr[n++] = scn.nextInt();
        }
        reverse(arr, n);
        // print the reversed array
        for (int k = 0; k < n; k++)
            System.out.println("N[" + k + "] = "+arr[k]);

    }
}
