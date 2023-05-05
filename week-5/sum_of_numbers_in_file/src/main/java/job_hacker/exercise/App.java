package job_hacker.exercise;

import java.io.*;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


    private static void print(File file, OperationEnum operation){
        try(Scanner scanner = new Scanner(file)) {
            int value = 0;
            if (operation == OperationEnum.Sum)
                value = Helper.getSumOfNumbers(scanner);
            else if (operation == OperationEnum.Average)
                value = Helper.getAverageOfNumbers(scanner);

            System.out.println(operation.name() + " of numbers in file is "+ value);
        } catch (FileNotFoundException e) {
            System.out.println("File " + Helper.FILE_NAME + " Not Found");
            System.out.println(e.getMessage());
        }
    }

    public static void main( String[] args )
    {
        try {
            Helper.readFromWebToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            File file = new File(App.class.getResource("/" + Helper.FILE_NAME).getFile());
            print(file, OperationEnum.Sum);
            print(file, OperationEnum.Average);

        } catch (NullPointerException nullPointerException){
            System.out.println("File " + Helper.FILE_NAME + " Not Found");
            System.out.println(nullPointerException.getMessage());
        }
    }
}
