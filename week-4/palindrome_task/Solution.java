package palindrome_task;

public class Solution {

  /**
   * isPalindrome - checks if it is a Palindrome (a word or phrase
   * that reads the same backward as forward)
   * 
   * @param s: string to check
   * @return: true if Palindrome
   *          otherwise false
   */
  public static boolean isPalindrome(String s) {
    char[] strArr = s.toCharArray();

    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (strArr[i] != strArr[j])
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("\"aaabbb\" is palindrome? " + isPalindrome("aaabbb"));
    System.out.println("______________________");
    System.out.println("\"aabaa\" is palindrome? " + isPalindrome("aabaa"));
  }
}