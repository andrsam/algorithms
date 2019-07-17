import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void isStringPalindrome() {
        assertTrue(PalindromeChecker.isStringPalindrome("а роза упала на лапу азора"));
        assertTrue(PalindromeChecker.isStringPalindrome("а РозА УПАЛА на лап уАзорА"));
        assertTrue(PalindromeChecker.isStringPalindrome("аргентина манит негра"));
        assertFalse(PalindromeChecker.isStringPalindrome("тест"));
    }
}