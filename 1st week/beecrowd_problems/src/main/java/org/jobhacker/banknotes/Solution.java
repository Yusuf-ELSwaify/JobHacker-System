package org.jobhacker.banknotes;

import java.util.Scanner;
public class Solution {
    static final int banknotes[] = { 100, 50, 20, 10, 5, 2, 1};
    public static void main(String[] args)  {
        try (Scanner scn = new Scanner(System.in))
        {
            int money = scn.nextInt();
            System.out.printf("%d\n",  money);
            for (int i = 0; i < banknotes.length; i++)
            {
                System.out.printf("%d nota(s) de R$ %d,00\n",  (money / banknotes[i]), banknotes[i]);
                money %= banknotes[i];
            }
        }
    }
}
