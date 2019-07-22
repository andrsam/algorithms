import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleStackQueueTest {
    DoubleStackQueue<Integer> queue = new DoubleStackQueue<>();

    @Test
    public void enqueue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void dequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.size());
    }
}