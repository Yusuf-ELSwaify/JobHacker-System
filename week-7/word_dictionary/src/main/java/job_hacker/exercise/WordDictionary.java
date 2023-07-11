package job_hacker.exercise;

import java.util.*;

public class WordDictionary {
    private Map<Character, Set<String>> words = new HashMap<>();
    public void addWord(String word) {
        if (word.length() > 0) {
            char firstLetter = Character.toLowerCase(word.charAt(0));
            words.computeIfAbsent(firstLetter, k -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER)).add(word);
        }
    }
    public void printAllWords() {
        for (Map.Entry<Character, Set<String>> entry : words.entrySet()) {
            char letter = entry.getKey();
            Set<String> wordSet = entry.getValue();
            System.out.printf("%c-> %s\n", letter, String.join(", ", wordSet));
        }
    }
    public void printWordsByLetter(char letter) {
        letter = Character.toLowerCase(letter);
        Set<String> wordSet = words.get(letter);

        if (wordSet == null)
            System.out.printf("No words starts with %c\n", letter);
        else
            System.out.printf("%c-> %s\n", letter, String.join(", ", wordSet));
    }
}
