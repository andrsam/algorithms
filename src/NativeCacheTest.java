import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NativeCacheTest {
    private NativeCache<Integer> nativeCache = new NativeCache<>(10);
    public static final String KEY = "1";

    @Test
    public void put() {
        nativeCache.put(KEY, 1);
        assertEquals(1, nativeCache.getStorage().get(KEY).intValue());
        assertEquals(0, nativeCache.getHits().get(KEY).intValue());
    }

    @Test
    public void get() {
        assertNull(nativeCache.get(KEY));
        nativeCache.put(KEY, 1);
        assertEquals(1, nativeCache.get(KEY).intValue());
        assertEquals(1, nativeCache.getHits().get(KEY).intValue());
    }

    @Test
    public void testCacheFull() {
        for (int i = 0; i < 10; i++) {
            nativeCache.put(String.valueOf(i), i);
        }

        for (int i = 0; i < 9; i++) {
            nativeCache.get(String.valueOf(i));
        }

        nativeCache.put("99", 99);
        assertNull(nativeCache.get("9"));

        assertEquals(99, nativeCache.get("99").intValue());
    }

}