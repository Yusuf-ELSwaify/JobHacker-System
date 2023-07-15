package job_hacker.exercise;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {

    public static File readFromWebToFile(String url) {
        Scanner scanner = null;
        try {
            URL scoreUrl = new URL(url);
            scanner = new Scanner(scoreUrl.openStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Cant open connection with " + url);
            throw new RuntimeException(e);
        }

        PrintWriter writer = null;
        File file = new File( App.FILE_NAME);
        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            System.out.println("cant create file " + file.getName());
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine())
            writer.println(scanner.nextLine());

        scanner.close();
        writer.close();

        return file;
    }
    private static int getAverageOrSum(File file, OperationEnum operationEnum){
        try(Scanner scanner = new Scanner(file)) {
            int wordCount = 0, sum = 0;

            while (scanner.hasNext()) {
                try {
                    sum += scanner.nextInt();
                    wordCount++;
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid number in the file-> " + scanner.next() + ".");
                }
            }
            if (wordCount == 0)
                return 0;
            return operationEnum == OperationEnum.Average ? (sum / wordCount) : sum;
        } catch (FileNotFoundException e) {
            System.out.println("File " + file.getName() + " Not Found");
            throw new RuntimeException(e);
        }
    }
    public static int getAverage(File file){
        return getAverageOrSum(file, OperationEnum.Average);
    }
    public static int getSum(File file){
        return getAverageOrSum(file, OperationEnum.Sum);
    }

}
