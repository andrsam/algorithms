import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracesBalanceCheckerTest {

    @Test
    public void isBracesBalanced() {
        assertTrue(BracesBalanceChecker.isBracesBalanced("(()((())()))"));
        assertFalse(BracesBalanceChecker.isBracesBalanced("(()()(()"));
        assertFalse(BracesBalanceChecker.isBracesBalanced("))(("));
        assertFalse(BracesBalanceChecker.isBracesBalanced("((())"));
        assertFalse(BracesBalanceChecker.isBracesBalanced("())("));
    }
}