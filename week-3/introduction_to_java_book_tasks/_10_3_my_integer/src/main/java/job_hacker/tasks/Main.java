package job_hacker.tasks;

import job_hacker.tasks.models.MyInteger;



public class Main {
    public static void main(String[] args) {

        MyInteger testObj = new MyInteger(123);
        if (testObj.isEven())
            System.out.println("MyInteger " + testObj.getValue() + " even");

        else if (testObj.isOdd())
            System.out.println("MyInteger " + testObj.getValue() + " odd");

        if (testObj.isPrime())
            System.out.println("MyInteger " + testObj.getValue() + " prime");
        System.out.println("_____________________________________");
        MyInteger staticTest = new MyInteger(122);
        if (MyInteger.isEven(staticTest))
            System.out.println("Static MyInteger " + staticTest.getValue() + " even");
        else if (MyInteger.isOdd(staticTest))
            System.out.println("Static MyInteger " + staticTest.getValue() + " odd");

        if (MyInteger.isPrime(staticTest))
            System.out.println("Static MyInteger " + staticTest.getValue() + " prime");
        System.out.println("_______________________________________");
        int numTest = 11;
        if (MyInteger.isEven(numTest))
            System.out.println("int " + numTest + " even");
        else if (MyInteger.isOdd(numTest))
            System.out.println("int  " + numTest + " odd");

        if (MyInteger.isPrime(numTest))
            System.out.println("int  " + numTest + " prime");
        System.out.println("_______________________________________");
        if (testObj.equals(staticTest))
            System.out.println("MyInteger " + testObj.getValue() + " equals MyInteger " + staticTest.getValue());
        else
            System.out.println("MyInteger " + testObj.getValue() + " not equals MyInteger " + staticTest.getValue());
        System.out.println("_______________________________________");

        if (testObj.equals(numTest))
            System.out.println("MyInteger " + testObj.getValue() + " equals int " + numTest);
        else
            System.out.println("MyInteger " + testObj.getValue() + " not equals int " + numTest);

        System.out.println("_______________________________________");
        char[] testArray = {'1', '2', '3', '4', '5'};

        System.out.println("parsing array of characters 1 2 3 4 5 " + MyInteger.parseInt(testArray));
        System.out.println("_______________________________________");

        String str = "100";

        System.out.println("parsing string \"100\" " + MyInteger.parseInt(str));

    }
}