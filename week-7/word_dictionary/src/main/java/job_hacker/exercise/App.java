package job_hacker.exercise;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("active");
        dictionary.addWord("argentina");
        dictionary.addWord("Ant");
        dictionary.addWord("banana");
        dictionary.addWord("Balloon");
        dictionary.addWord("Bird");
        dictionary.addWord("cat");
        dictionary.addWord("Chair");
        dictionary.addWord("duck");
        dictionary.addWord("Door");
        dictionary.addWord("egg");
        System.out.println("Print all letters and corresponding words.");
        dictionary.printAllWords();

        System.out.println("______________");
        System.out.println("Print the words of the given letter.");
        dictionary.printWordsByLetter('c');
        dictionary.printWordsByLetter('a');
        dictionary.printWordsByLetter('B');
        dictionary.printWordsByLetter('f');
    }
}
