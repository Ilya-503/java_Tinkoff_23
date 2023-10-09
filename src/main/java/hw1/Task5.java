package hw1;

import java.util.stream.IntStream;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("1237321"));
    }
   public static boolean isPalindromeDescendant(int num) {
       try {
           num = Math.abs(num);
           String numStr = String.valueOf(num);

           while (numStr.length() > 1) {
               if (isPalindrome(numStr)) {
                   return true;
               }
               numStr = getDescendant(numStr);
           }
           return false;
       } catch (NullPointerException e) {
           return false;
       }
   }
   private static boolean isPalindrome(String numStr) {
        int len = numStr.length();
        int r = len / 2;
        return IntStream
            .range(0, r)
            .allMatch(idx -> numStr.charAt(idx) == numStr.charAt(len - idx - 1));
   }
   private static String getDescendant(String numStr) {
        int len = numStr.length();
        StringBuilder result = new StringBuilder(len);

       for (int i = 0; i < len - len % 2 - 1; i += 2) {
           result.append(numStr.charAt(i) - '0' + numStr.charAt(i + 1) - '0');
       }

       result.append(
           len % 2 == 1 ? numStr.charAt(len - 1) : ""
       );
       return result.toString();
   }
}
