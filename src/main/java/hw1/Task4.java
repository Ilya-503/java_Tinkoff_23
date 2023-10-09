package hw1;

public class Task4 {
    public static String getCorrectStr(String str) {
        try {
            int len = str.length();
            StringBuilder result = new StringBuilder(len);

            for (int i = 0; i < len - len % 2 - 1; i += 2) {
                result
                    .append(str.charAt(i + 1))
                    .append(str.charAt(i));
            }

            result.append(
                len % 2 == 1 ? str.charAt(len - 1) : ""
            );

            return result.toString();

        } catch (NullPointerException e) {
            return "";
        }
    }
}
