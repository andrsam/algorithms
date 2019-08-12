import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    private HashTable hashTableBig = new HashTable(17, 3);
    private HashTable hashTableSmall = new HashTable(3, 3);

    @Test
    public void seekSlot() {
        assertNotEquals(-1, hashTableBig.seekSlot("a"));
        int index = hashTableBig.put("a");
        assertNotEquals(-1, index);
        assertEquals(index + hashTableBig.step, hashTableBig.put("a"));

        index = hashTableSmall.put("a");
        assertNotEquals(-1, index);
        assertEquals(0, hashTableSmall.put("a"));
    }

    @Test
    public void find() {
        assertEquals(-1, hashTableBig.find("a"));
        hashTableBig.put("a");
        assertTrue(hashTableBig.find("a") > -1);
    }
}