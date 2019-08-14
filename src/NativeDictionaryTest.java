import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NativeDictionaryTest {
    private NativeDictionary<Integer> dictionary = new NativeDictionary<>(10, Integer.class);

    @Test
    public void isKey() {
        dictionary.put("a", 1);
        assertTrue(dictionary.isKey("a"));
    }

    @Test
    public void get() {
        dictionary.put("a", 1);
        dictionary.put("b", 2);
        assertEquals(1, dictionary.get("a").intValue());
        assertEquals(2, dictionary.get("b").intValue());
    }
}