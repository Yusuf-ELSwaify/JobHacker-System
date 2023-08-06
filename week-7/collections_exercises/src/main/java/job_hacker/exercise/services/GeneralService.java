package job_hacker.exercise.services;

import java.util.Scanner;

public abstract class GeneralService {
    protected final Scanner sc;
    protected GeneralService(Scanner sc){
        this.sc = sc;
    }
    public void queryExecutor(char query) {
        switch (query) {
            case 'a':
                aQuery();
                break;
            case 'b':
                bQuery();
                break;
            case 'c':
                cQuery();
                break;
            case 'd':
                dQuery();
                break;
            case 'e':
                eQuery();
                break;
            case 'f':
                fQuery();
                break;
            default:
                throw new IllegalArgumentException();

        }
        System.out.println();
    }
    public abstract void clear();

    protected abstract void aQuery();
    protected abstract void bQuery();
    protected abstract void cQuery();
    protected abstract void dQuery();

    protected abstract void eQuery();

    protected abstract void fQuery();

}
