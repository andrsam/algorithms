import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
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
    }

    @Test
    public void insert() {
        fillArray(8);
        dynArray.insert(32, 1);
        assertArrayEquals(new Integer[]{1, 32, 1, 1, 1, 1, 1, 1}, Arrays.copyOfRange(dynArray.array, 0, 8));
        assertEquals(9, dynArray.count);
        assertEquals(dynArray.MIN_CAPACITY, dynArray.capacity);
        fillArray(16);
        dynArray.insert(32, 1);
        assertEquals(32, dynArray.getItem(1));
        assertEquals(32, dynArray.capacity);
        assertEquals(17, dynArray.count);
    }


    @Test
    public void remove() {
        dynArray.remove(0);
        assertEquals(0, dynArray.count);
        fillArray(8);
        dynArray.remove(1);
        assertEquals(7, dynArray.count);
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
        dynArray.remove(-1);
    }

    private void fillArray(int length) {
        Arrays.fill(dynArray.array, 0, length, 1);
        dynArray.count = length;
    }

}