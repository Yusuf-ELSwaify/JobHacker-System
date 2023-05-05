package job_hacker.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
    public static final String FILE_NAME = "Scores.txt";
    private static final String URL = "http://liveexample.pearsoncmg.com/data/Scores.txt";
    public static void readFromWebToFile() throws IOException {
        URL scoreUrl = new URL(URL);
        Scanner scanner = new Scanner(scoreUrl.openStream());
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + "Scores.txt"));
        BufferedWriter targetWriter = new BufferedWriter(new FileWriter("target/classes/" + "Scores.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            writer.write(line);
            targetWriter.write(line);
            writer.newLine();
            targetWriter.newLine();
        }

        scanner.close();
        writer.close();
        targetWriter.close();
    }
    private static int getAverageOrSum(Scanner scanner, OperationEnum operationEnum){
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
    }
    public static int getAverageOfNumbers(Scanner scanner){
        return getAverageOrSum(scanner, OperationEnum.Average);
    }
    public static int getSumOfNumbers(Scanner scanner){
        return getAverageOrSum(scanner, OperationEnum.Sum);
    }

}
