public class PalindromeChecker {


    public static boolean isStringPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        char[] chars = lowerCase.toCharArray();
        Deque<Character> deque = new Deque<>();
        for (char chr : chars) {
            deque.addFront(chr);
        }

        StringBuilder builder = new StringBuilder();
        while (deque.size() != 0) {
            builder.append(deque.removeTail());
        }

        return lowerCase.equals(builder.toString());
    }
}
