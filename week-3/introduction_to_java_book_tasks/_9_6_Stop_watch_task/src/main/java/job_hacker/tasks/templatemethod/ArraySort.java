package job_hacker.tasks.templatemethod;

import java.util.Random;

public abstract class ArraySort {
    protected int[] arr;
    public final void fillSortArray(){
        arr = new int[100_000];
        fillArray();
        sort();
        //printArray();
    }
    private void fillArray(){
        Random rand = new Random(1000);
        for (int i = 0; i < 100_000; i++) {
            arr[i] = rand.nextInt();
        }
    }
    private void printArray() {
        for (int num: arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
    protected abstract void sort();
}
