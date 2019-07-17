public class PalindromeChecker {


    public static boolean isStringPalindrome(String s) {
        String lowerCase = s.toLowerCase().replace(" ", "");
        char[] chars = lowerCase.toCharArray();
        Deque<Character> deque = new Deque<>();
        for (char chr : chars) {
            deque.addFront(chr);
        }

        boolean result = true;
        while (deque.size() > 0) {
            Character front = deque.removeFront();
            Character tail = deque.removeTail();
            if (front != null && tail != null && !front.equals(tail)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
