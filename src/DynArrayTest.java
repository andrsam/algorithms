import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DynArrayTest {
    private DynArray dynArray = new DynArray(Integer.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getItem() throws ArrayIndexOutOfBoundsException {
       dynArray.array[0] = 1;
       assertEquals(1, dynArray.getItem(0));
       dynArray.getItem(DynArray.MIN_CAPACITY+1);
       thrown.expect(ArrayIndexOutOfBoundsException.class);
       dynArray.getItem(-1);
       thrown.expect(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    public void append() {
        dynArray.append(1);
        assertEquals(1, dynArray.getItem(0));
    }

    @Test
    public void insert() {
        for (int i = 0; i < 7; i++) {
            dynArray.append(1);
        }
        dynArray.insert(5, 1);
        assertEquals(5, dynArray.getItem(1));
    }

    @Test
    public void remove() {
    }
}