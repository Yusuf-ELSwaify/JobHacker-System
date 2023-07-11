package job_hacker.exercise.services;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetService extends SetService{
    public HashSetService(Scanner sc) {
        super(new HashSet<>(), sc);
    }
}
