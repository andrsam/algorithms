import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class DynArrayTest {
    private DynArray dynArray = new DynArray(Integer.class);

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getItemWrongPosition() {
        dynArray.getItem(-1);
        dynArray.getItem(16);
    }

    @Test
    public void append() {
        dynArray.append(1);
        assertEquals(1, dynArray.getItem(0));
        assertEquals(1, dynArray.count);
        assertEquals(dynArray.MIN_CAPACITY, dynArray.capacity);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insertToWrongPosition() {
        fillArray(8);
        dynArray.insert(32, -1);
        dynArray.insert(64, 64);
    }

    @Test
    public void insert() {
        fillArray(dynArray.MIN_CAPACITY);
        assertEquals(dynArray.MIN_CAPACITY, dynArray.count);
        dynArray.insert(99, 0);
        assertEquals(99, dynArray.getItem(0));
        assertEquals(dynArray.MIN_CAPACITY * 2, dynArray.capacity);
        assertEquals(dynArray.MIN_CAPACITY + 1, dynArray.count);
        dynArray = new DynArray(Integer.class);
        fillArray(dynArray.MIN_CAPACITY);
        dynArray.append(99);
        assertEquals(99, dynArray.getItem(dynArray.MIN_CAPACITY));
        assertEquals(dynArray.MIN_CAPACITY * 2, dynArray.capacity);
        assertEquals(dynArray.MIN_CAPACITY + 1, dynArray.count);
    }


    @Test
    public void remove() {
        fillArray(8);
        dynArray.remove(1);
        assertEquals(7, dynArray.count);
        dynArray = new DynArray(Integer.class);
        dynArray.makeArray(32);
        fillArray(16);
        dynArray.remove(1);
        assertEquals(21, dynArray.capacity);
        while (dynArray.count > 9) {
            dynArray.remove(0);
        }
        assertEquals(dynArray.MIN_CAPACITY, dynArray.capacity);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeFromWrongPosition() {
        dynArray.remove(0);
        assertEquals(0, dynArray.count);
        assertEquals(dynArray.MIN_CAPACITY, dynArray.capacity);
        assertEquals(dynArray.MIN_CAPACITY, dynArray.array.length);

        dynArray.remove(2);
        dynArray.remove(-1);
        dynArray.remove(17);
    }

    private void fillArray(int length) {
        for (int i = 0; i < length; i++) {
            dynArray.append(i);
        }
    }

}