package job_hacker.exercise.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetRepository {
    private final Set<Integer> set;
    public SetRepository(Set<Integer> set){
        this.set = set;
    }
    public void add(int num) {
        set.add(num);
    }
    public void remove(int num) {
        set.remove(num);
    }
    public int getSize() {
        return set.size();
    }
    public List<Integer> getList() {
        return new ArrayList<>(set);
    }
    public List<Integer> getSortedList() {
        return set.stream().sorted().collect(Collectors.toList());
    }
    public int isContain(int num) {
        return set.contains(num) ? 1 : -1;
    }
    public void clear(){
        set.clear();
    }
}
