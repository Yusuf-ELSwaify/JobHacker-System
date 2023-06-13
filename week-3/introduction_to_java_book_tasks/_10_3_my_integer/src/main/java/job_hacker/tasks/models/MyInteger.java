package job_hacker.tasks.models;

public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public boolean isEven(){
        return (value & 1) == 0;
    }
    public boolean isOdd(){
        return (value & 1) == 1;
    }
    public boolean isPrime(){
        if (value <= 1) {
            return false;
        }
        if (value % 2 == 0) {
            return value == 2;
        }
        if (value % 3 == 0) {
            return value == 3;
        }
        for (int i = 5; i * i <= value; i += 6) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(int num) {
        MyInteger myNum = new MyInteger(num);
        return myNum.isEven();
    }
    public static boolean isOdd(int num) {
        MyInteger myNum = new MyInteger(num);
        return myNum.isOdd();
    }
    public static boolean isPrime(int num) {
        MyInteger myNum = new MyInteger(num);
        return myNum.isPrime();
    }
    public static boolean isEven(MyInteger myNum) {
        return myNum.isEven();
    }
    public static boolean isOdd(MyInteger myNum) {
        return myNum.isOdd();
    }
    public static boolean isPrime(MyInteger myNum) {
        return myNum.isPrime();
    }
    public boolean equals(int num)
    {
        return value == num;
    }
    public boolean equals(MyInteger myNum)
    {
        return value == myNum.value;
    }
    public static int parseInt(char[] chars) {
        return Integer.parseInt(new String(chars));
    }
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
