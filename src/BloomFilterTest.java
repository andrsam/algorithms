import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloomFilterTest {
    private BloomFilter filter = new BloomFilter(10);

    @Test
    public void isValue() {
        assertFalse(filter.isValue("0123456789"));
        filter.add("0123456789");
        assertTrue(filter.isValue("0123456789"));
        assertFalse(filter.isValue("999999999"));
    }
}