import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DequeTest {
    private Deque<Integer> deque = new Deque<>();

    @Test
    public void addFront() {
        deque.addFront(1);
        assertEquals(1, deque.size());
        assertEquals(1, deque.getHead().intValue());
        assertEquals(1, deque.getTail().intValue());

        deque.addFront(2);
        assertEquals(2, deque.size());
        assertEquals(2, deque.getHead().intValue());
        assertEquals(1, deque.getTail().intValue());
    }

    @Test
    public void addTail() {
        deque.addTail(1);
        assertEquals(1, deque.size());
        assertEquals(1, deque.getHead().intValue());
        assertEquals(1, deque.getTail().intValue());

        deque.addTail(2);
        assertEquals(2, deque.size());
        assertEquals(1, deque.getHead().intValue());
        assertEquals(2, deque.getTail().intValue());
    }

    @Test
    public void removeFront() {
        assertNull(deque.removeFront());
        deque.addFront(1);
        deque.addFront(2);
        assertEquals(2, deque.removeFront().intValue());
        assertEquals(1, deque.size());
        assertEquals(1, deque.getHead().intValue());
        assertEquals(1, deque.getTail().intValue());
    }

    @Test
    public void removeTail() {
        assertNull(deque.removeTail());
        deque.addFront(1);
        deque.addFront(2);
        assertEquals(1, deque.removeTail().intValue());
        assertEquals(1, deque.size());
        assertEquals(2, deque.getHead().intValue());
        assertEquals(2, deque.getTail().intValue());
    }
}