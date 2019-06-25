public class BracesBalanceChecker {

    public static boolean isBracesBalanced(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (stack.size() != 0) {
                stack.pop();
            }

        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBracesBalanced("(()()(()"));
    }
}
