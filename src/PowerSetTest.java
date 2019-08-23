import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PowerSetTest {
    PowerSet<Integer> set1 = new PowerSet<>(Integer.class);
    PowerSet<Integer> set2 = new PowerSet<>(Integer.class);

    @Test
    public void intersection() {
        assertEquals(0, set1.intersection(set2).size());

        set1.fillFromList(Arrays.asList(1, 2, 3, 4, 7));
        set2.fillFromList(Arrays.asList(2, 3, 5, 7));
        assertEquals(Arrays.asList(2, 3, 7), set1.intersection(set2).asList());

        set1.fillFromList(Arrays.asList(1, 3, 5, 7));
        set2.fillFromList(Arrays.asList(2, 4, 6, 8));
        assertTrue(set1.intersection(set2).asList().isEmpty());

    }

    @Test
    public void union() {
        assertEquals(0, set1.union(set2).size());

        set1.fillFromList(Arrays.asList(1, 2, 3, 4, 7));
        assertEquals(Arrays.asList(1, 2, 3, 4, 7), set1.union(set2).asList());

        set2.fillFromList(Arrays.asList(2, 3, 5, 7));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7), set1.union(set2).asList());
    }

    @Test
    public void difference() {
        assertEquals(0, set1.difference(set2).size());

        set1.fillFromList(Arrays.asList(1, 2, 3, 4, 7));
        assertEquals(0, set1.difference(set1).size());

        set2.fillFromList(Arrays.asList(2, 3, 5, 7));
        assertEquals(Arrays.asList(1, 4), set1.difference(set2).asList());
    }

    /**
     * - issubset(), в качестве параметра выступает другое множество, и проверяется,
     * входят ли все его элементы в текущее множество (будет ли множество-параметр подмножеством текущего множества).
     */


    @Test
    public void isSubset() {
        //рассмотрите три случая (все элементы параметра входят в текущее множество,
        // все элементы текущего множества входят в параметр, не все элементы параметра входят в текущее множество).

        set1.fillFromList(Arrays.asList(2, 3, 5));
        set2.fillFromList(Arrays.asList(2, 3, 5, 7));
        assertTrue(set2.isSubset(set1));
        assertFalse(set1.isSubset(set2));

        set1.fillFromList(Arrays.asList(2, 3, 5));
        set2.fillFromList(Arrays.asList(2, 3, 5));
        assertTrue(set1.isSubset(set2));


    }

    @Test
    public void remove() {
        set1.fillFromList(Arrays.asList(2, 3, 5));
        assertTrue(set1.remove(2));
        assertFalse(set1.remove(7));
    }

    @Test
    public void put() {
        set1.put(20001);
        assertEquals(20002, set1.slots.size());
        assertTrue(set1.get(20001));
    }
}