package edu.homework1;

import java.util.stream.IntStream;

public final class Task5 {

    private Task5() {
    }

    public static boolean isPalindromeDescendant(final int num) {
       try {
           int absNum = Math.abs(num);
           String numStr = String.valueOf(absNum);

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

   private static boolean isPalindrome(final String numStr) {
        int len = numStr.length();
        int r = len / 2;
        return IntStream
            .range(0, r)
            .allMatch(idx -> numStr.charAt(idx) == numStr.charAt(len - idx - 1));
   }

   private static String getDescendant(final String numStr) {
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
