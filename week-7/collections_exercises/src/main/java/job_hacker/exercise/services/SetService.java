package job_hacker.exercise.services;

import job_hacker.exercise.repositories.SetRepository;

import java.util.Scanner;
import java.util.Set;

abstract class SetService extends GeneralService{
    private final SetRepository repo;
    protected SetService(Set<Integer> set, Scanner sc){
        super(sc);
        this.repo= new SetRepository(set);
    }

    public void clear(){
        repo.clear();
    }
    @Override
    protected void aQuery() {
        repo.add(sc.nextInt());
    }

    @Override
    protected void bQuery() {
        repo.getSortedList().forEach((c) -> System.out.print(c + " "));
    }

    @Override
    protected void cQuery() {
        repo.remove(sc.nextInt());
    }

    @Override
    protected void dQuery() {
        System.out.println(repo.isContain(sc.nextInt()));
    }

    @Override
    protected void eQuery() {
        System.out.println(repo.getSize());
    }

    @Override
    protected void fQuery() {
        repo.getList().forEach((c) -> System.out.print(c + " "));
    }
}
