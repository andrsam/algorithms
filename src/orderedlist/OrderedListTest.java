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
        assertEquals(2, orderedListIntAsc.tail.value.intValue());
        assertEquals("-1,1,2", orderedListIntAsc.asString());

        orderedListIntAsc.add(1);
        //[-1, 1, 1, 2]
        assertEquals(4, orderedListIntAsc.count());
        assertEquals(2, orderedListIntAsc.tail.value.intValue());
        assertEquals(-1, orderedListIntAsc.head.value.intValue());
        assertEquals("-1,1,1,2", orderedListIntAsc.asString());

        orderedListIntDesc.add(1);
        orderedListIntDesc.add(2);
        orderedListIntDesc.add(9);
        assertEquals(3, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals("9,2,1", orderedListIntDesc.asString());

        orderedListIntDesc.add(2);
        assertEquals(4, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals(1, orderedListIntDesc.tail.value.intValue());
        assertEquals("9,2,2,1", orderedListIntDesc.asString());

        orderedListIntDesc.add(3);
        assertEquals(5, orderedListIntDesc.count());
        assertEquals(9, orderedListIntDesc.head.value.intValue());
        assertEquals(1, orderedListIntDesc.tail.value.intValue());
        assertEquals("9,3,2,2,1", orderedListIntDesc.asString());

        orderedListStrAsc.add("a");
        orderedListStrAsc.add("b");
        assertEquals(2, orderedListStrAsc.count());
        assertEquals("a", orderedListStrAsc.head.value);
        assertEquals("b", orderedListStrAsc.tail.value);
        assertEquals("a,b", orderedListStrAsc.asString());

        orderedListStrAsc.add("");
        assertEquals(3, orderedListStrAsc.count());
        assertEquals("", orderedListStrAsc.head.value);
        assertEquals("b", orderedListStrAsc.tail.value);
        assertEquals(",a,b", orderedListStrAsc.asString());

        orderedListStrDesc.add("a");
        orderedListStrDesc.add("b");
        assertEquals(2, orderedListStrDesc.count());
        assertEquals("b", orderedListStrDesc.head.value);
        assertEquals("a", orderedListStrDesc.tail.value);
        assertEquals("b,a", orderedListStrDesc.asString());

        orderedListStrDesc.add("");
        assertEquals(3, orderedListStrDesc.count());
        assertEquals("b", orderedListStrDesc.head.value);
        assertEquals("", orderedListStrDesc.tail.value);
        assertEquals("b,a,", orderedListStrDesc.asString());

        orderedListStrDesc.add("c");
        assertEquals(4, orderedListStrDesc.count());
        assertEquals("c", orderedListStrDesc.head.value);
        assertEquals("", orderedListStrDesc.tail.value);
        assertEquals("c,b,a,", orderedListStrDesc.asString());

        orderedListStrDesc.add("f");
        orderedListStrDesc.add("e");
        assertEquals("f,e,c,b,a,", orderedListStrDesc.asString());
    }

    @Test
    public void find() {
        assertNull(orderedListIntAsc.find(3));
        orderedListIntAsc.add(1);
        orderedListIntAsc.add(2);
        orderedListIntAsc.add(3);
        assertEquals(2, orderedListIntAsc.find(2).value.intValue());
        assertNull(orderedListIntAsc.find(-1));
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