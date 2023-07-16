package job_hacker.exercise;

import java.io.*;


public class App 
{
    public static final String FILE_NAME = "Scores.txt";
    private static final String URL = "http://liveexample.pearsoncmg.com/data/Scores.txt";

    private static void print(File file, OperationEnum operation){

        int value = 0;
        if (operation == OperationEnum.Sum)
            value = Helper.getSum(file);
        else if (operation == OperationEnum.Average)
            value = Helper.getAverage(file);

        System.out.println(operation.name() + " of numbers in file is "+ value);
    }

    public static void main( String[] args )
    {
        File file = Helper.readFromWebToFile(URL);
        print(file, OperationEnum.Sum);
        print(file, OperationEnum.Average);
    }
}
