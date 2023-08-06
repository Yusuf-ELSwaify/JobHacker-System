package job_hacker.exercise.services;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LinkedHashSetService extends SetService{

    public LinkedHashSetService(Scanner sc) {
        super(new LinkedHashSet<>(), sc);
    }
}
