@SuppressWarnings("unchecked")
public class PostfixNotationCalculator {

    public int computeExpression(String expression) {
        Stack expressionStack = new Stack();
        Stack operandsStack = new Stack();

        String[] arr = expression.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            expressionStack.push(arr[i]);
        }

        int result = 0;
        String elem = "";
        while (expressionStack.size() > 0 && !elem.equals("=")) {
            elem = expressionStack.pop().toString();

            if (elem.matches("[0-9]+")) {
                operandsStack.push(elem);
            } else if (operandsStack.size() >= 2) {
                result = calcOperation(operandsStack.pop().toString(), operandsStack.pop().toString(), elem);
                operandsStack.push(result);
            } else if (operandsStack.size() == 1) {
                result = Integer.parseInt(operandsStack.pop().toString());
            }
        }

        return result;
    }

    private int calcOperation(String a, String b, String operation) {
        int a_ = Integer.parseInt(a);
        int b_ = Integer.parseInt(b);

        int result = 0;

        switch (operation) {
            case "+":
                result = a_ + b_;
                break;
            case "*":
                result = a_ * b_;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("+".matches("[0-9]+|\\+|\\*"));
    }
}
