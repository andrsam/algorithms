import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HashTableTest {
    private HashTable hashTableBig = new HashTable(17, 3);
    private HashTable hashTableSmall = new HashTable(3, 1);

    @Test
    public void seekSlot() {
        assertNotEquals(-1, hashTableBig.seekSlot("a"));
        int index = hashTableBig.put("a");
        assertNotEquals(-1, index);
        assertEquals(index + hashTableBig.step, hashTableBig.put("a"));
    }

    @Test
    public void put() {
        hashTableSmall.put("a");
        hashTableSmall.put("b");
        hashTableSmall.put("c");

        assertFalse(Arrays.asList(hashTableSmall.slots).contains(null));

        for (int i = 0; i < 18; i++) {
            hashTableBig.put(String.valueOf(i));
        }

        assertFalse(Arrays.asList(hashTableBig.slots).contains(null));
    }

    @Test
    public void find() {
        assertEquals(-1, hashTableBig.find("a"));
        hashTableBig.put("a");
        assertTrue(hashTableBig.find("a") > -1);
    }
}