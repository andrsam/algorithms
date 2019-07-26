package orderedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderedListTest {
    private OrderedList<Integer> orderedListIntAsc = new OrderedList<>(true);
    private OrderedList<Integer> orderedListIntDesc = new OrderedList(false);

    private OrderedList<String> orderedListStrAsc = new OrderedList<>(true);
    private OrderedList<String> orderedListStrDesc = new OrderedList(false);

    @Test
    public void add() {
        orderedListIntAsc.add(1);
        orderedListIntAsc.add(2);
        orderedListIntAsc.add(-1);
        //[-1, 1, 2]
        assertEquals(3, orderedListIntAsc.count());
        assertEquals(-1, orderedListIntAsc.head.value.intValue());
        assertEquals(1, orderedListIntAsc.head.next.value.intValue());
        assertEquals(2, orderedListIntAsc.tail.value.intValue());
        assertEquals(1, orderedListIntAsc.tail.prev.value.intValue());

        orderedListIntAsc.add(1);
        //[-1, 1, 1, 2]
        assertEquals(4, orderedListIntAsc.count());
        assertEquals(1, orderedListIntAsc.tail.prev.value.intValue());
        assertEquals(1, orderedListIntAsc.head.next.value.intValue());
        assertEquals(2, orderedListIntAsc.tail.value.intValue());
        assertEquals(-1, orderedListIntAsc.head.value.intValue());

        orderedListIntDesc.add(1);
        orderedListIntDesc.add(2);
        orderedListIntDesc.add(9);
        assertEquals(3, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals(2, orderedListIntDesc.head.next.value.intValue());
        assertEquals(1, orderedListIntDesc.tail.value.intValue());
        assertEquals(2, orderedListIntDesc.tail.prev.value.intValue());

        orderedListIntDesc.add(2);
        assertEquals(4, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals(2, orderedListIntDesc.head.next.value.intValue());
        assertEquals(1, orderedListIntDesc.tail.value.intValue());
        assertEquals(2, orderedListIntDesc.tail.prev.value.intValue());

        orderedListIntDesc.add(3);
        assertEquals(5, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals(3, orderedListIntDesc.head.next.value.intValue());
        assertEquals(1, orderedListIntDesc.tail.value.intValue());
        assertEquals(2, orderedListIntDesc.tail.prev.value.intValue());

        orderedListStrAsc.add("a");
        orderedListStrAsc.add("b");
        assertEquals(2, orderedListStrAsc.count());
        assertEquals("a", orderedListStrAsc.head.value);
        assertEquals("b", orderedListStrAsc.head.next.value);
        assertEquals("b", orderedListStrAsc.tail.value);
        assertEquals("a", orderedListStrAsc.tail.prev.value);

        orderedListStrDesc.add("a");
        orderedListStrDesc.add("b");
        assertEquals(2, orderedListStrDesc.count());
        assertEquals("b", orderedListStrDesc.head.value);
        assertEquals("a", orderedListStrDesc.head.next.value);
        assertEquals("a", orderedListStrDesc.tail.value);
        assertEquals("b", orderedListStrDesc.tail.prev.value);
    }

    @Test
    public void find() {
        assertNull(orderedListIntAsc.find(3));
        orderedListIntAsc.add(1);
        orderedListIntAsc.add(2);
        orderedListIntAsc.add(3);
        assertEquals(2, orderedListIntAsc.find(2).value.intValue());
    }

    @Test
    public void delete() {
        orderedListIntAsc.add(1);
        orderedListIntAsc.add(2);
        orderedListIntAsc.add(3);
        orderedListIntAsc.add(4);

        orderedListIntAsc.delete(1);
        assertEquals(2, orderedListIntAsc.head.value.intValue());
        assertEquals(4, orderedListIntAsc.tail.value.intValue());

        orderedListIntAsc.delete(4);
        assertEquals(3, orderedListIntAsc.tail.value.intValue());
    }
}