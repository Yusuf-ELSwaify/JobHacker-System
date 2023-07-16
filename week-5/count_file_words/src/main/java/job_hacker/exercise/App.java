package job_hacker.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    private static final String FILE_NAME = "/Lincoln.txt";
    public static void main(String[] args) {
        try {
            File file = new File(App.class.getResource(FILE_NAME).getFile());

            try(Scanner scanner = new Scanner(file)) {
                int wordCount = 0;
                scanner.useDelimiter(Pattern.compile("\\W+"));
                while (scanner.hasNext()) {
                    scanner.next();
                    wordCount++;
                }
                System.out.println("The number of words in the file "+ FILE_NAME +" is " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("File " + FILE_NAME + " Not Found");
                System.out.println(e.getMessage());
            }

        } catch (NullPointerException nullPointerException){
            System.out.println("File " + FILE_NAME + " Not Found");
            System.out.println(nullPointerException.getMessage());
        }
    }
}
