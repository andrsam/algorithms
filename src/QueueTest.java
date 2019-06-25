import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class QueueTest {
    private Queue queue = new Queue();

    @Test
    public void size() {
        assertEquals(0, queue.size());
        queue.push(1);
        queue.push("test");
        assertEquals(2, queue.size());
    }

    @Test
    public void pop() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.pop());
    }

    @Test
    public void push() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void peek() {
        queue.push(1);
        assertEquals(1, queue.peek());
    }
}