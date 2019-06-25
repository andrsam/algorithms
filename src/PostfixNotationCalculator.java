@SuppressWarnings("unchecked")
public class PostfixNotationCalculator {
    private Stack expressionStack = new Stack();
    private Stack operandsStack = new Stack();

    public int computeExpression(String expression) {
        String[] arr = expression.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            expressionStack.push(arr[i]);
        }

        int result = 0;
        String elem = "";
        while (expressionStack.size() > 0 && !elem.equals("=")) {
            elem = expressionStack.pop().toString();
            if (!(elem.equals("+") || elem.equals("*"))) {
                operandsStack.push(elem);
            } else {
                result = calcOperation(operandsStack.pop().toString(), operandsStack.pop().toString(), elem);
                operandsStack.push(result);
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
}
