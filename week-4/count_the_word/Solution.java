package count_the_word;

import java.util.StringTokenizer;


public class Solution {
    public static int countWord1(String input, String givenWord) {
        int count = 0;
        int index = input.indexOf(givenWord);

        while (index != -1)
        {
            index = input.indexOf(givenWord, index + 1);
            ++count;
        }
        return count;
    }

    public static int countWord2(String input, String givenWord){
        int count = 0;

        String[] words = input.split("\\s+");
        for (String word : words) {
            if (givenWord.equals(word))
                ++count;
        }
        return count;
    }
    
    public static int countWord3(String input, String givenWord) {
        int count = 0;

        StringTokenizer tokens = new StringTokenizer(input);
        while (tokens.hasMoreTokens()) {
            if (givenWord.equals(tokens.nextToken()))
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countWord1("Hello world, HEllo Hello", "Hello"));
        System.out.println(countWord2("Hello world, HEllo Hello", "Hello"));
        System.out.println(countWord3("Hello world, HEllo Hello", "Hello"));
    }
}
