import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostfixNotationCalculatorTest {
    PostfixNotationCalculator calculator = new PostfixNotationCalculator();

    @Test
    public void computeExpression() {
        assertEquals(59, calculator.computeExpression("8 2 + 5 * 9 + ="));
        assertEquals(9, calculator.computeExpression("1 2 + 3 *"));
    }
}