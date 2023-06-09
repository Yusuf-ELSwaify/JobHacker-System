package reverse_task;

public class Solution {

  public static String reverseString(String s) {
    char[] strArr = s.toCharArray();

    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      char temp = strArr[i];
      strArr[i] = strArr[j];
      strArr[j] = temp;
    }
    return new String(strArr);
  }

  public static void main(String[] args) {
    System.out.println("The reverse of \"aaabbb\" is: " + reverseString("aaabbb"));
    System.out.println("______________________");
    System.out.println("The reverse of \"aabbb\" is: " + reverseString("aabbb"));
  }
}