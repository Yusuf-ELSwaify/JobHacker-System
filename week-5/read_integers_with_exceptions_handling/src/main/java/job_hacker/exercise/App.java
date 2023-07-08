package job_hacker.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public final static int NUMBER_OF_INPUTS = 2;
    public static void main(String[] args) {
        int[] nums = new int[NUMBER_OF_INPUTS];
        int sum = 0;

        System.out.println("Enter " + NUMBER_OF_INPUTS + " numbers to sum them");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < NUMBER_OF_INPUTS; ) {
            try {
                System.out.print("Enter number "+ (i + 1) +": ");
                nums[i] = input.nextInt();
                ++i;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a correct number.");
                input.nextLine();
            }
        }
        input.close();

        for (int n : nums)
            sum += n;

        System.out.println(sum);
    }
}
