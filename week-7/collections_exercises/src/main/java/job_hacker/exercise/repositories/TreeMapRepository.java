package job_hacker.exercise.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapRepository {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();
    public void add(int key, int value) {
        map.put(key, value);
    }
    public void remove(int key) {
        map.remove(key);
    }
    public int getSize() {
        return map.size();
    }
    public int getValue(int num) {
        return map.getOrDefault(num, -1);
    }
    public List<Integer> getList() {
        return new ArrayList<>(map.keySet());
    }
    public List<Integer> getSortedList() {
        return map.keySet().stream()
                .sorted((a, b) -> map.get(a).compareTo(map.get(b)))
                .collect(Collectors.toList());
    }
    public void clear(){
        map.clear();
    }
}
