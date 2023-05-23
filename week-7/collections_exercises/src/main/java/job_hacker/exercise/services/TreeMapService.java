package job_hacker.exercise.services;

import job_hacker.exercise.repositories.TreeMapRepository;

import java.util.Scanner;

public class TreeMapService extends GeneralService{
    private final TreeMapRepository repo = new TreeMapRepository();
    public TreeMapService(Scanner sc){
        super(sc);
    }

    public void clear(){
        repo.clear();
    }
    @Override
    protected void aQuery() {
        repo.add(sc.nextInt(), sc.nextInt());
    }
    @Override
    protected void bQuery() {
        System.out.println(repo.getValue(sc.nextInt()));
    }
    @Override
    protected void cQuery() {
        System.out.println(repo.getSize());
    }
    @Override
    protected void dQuery() {
        repo.remove(sc.nextInt());
    }
    @Override
    protected void eQuery() {
        repo.getSortedList().forEach((c) -> System.out.print(c + " "));
    }
    @Override
    protected void fQuery() {
        throw new IllegalArgumentException();
    }
}
