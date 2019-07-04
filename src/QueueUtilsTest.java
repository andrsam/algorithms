import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueUtilsTest {
    private Queue<Integer> queue = new Queue<>();


    public Queue<Integer> createQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        return queue;
    }

    @Test
    public void rotateQueue() {
        QueueUtils.rotateQueue(queue, 0);
        assertEquals(0, queue.size());

        QueueUtils.rotateQueue(queue, -1);
        assertEquals(0, queue.size());

        queue = createQueue();
        QueueUtils.rotateQueue(queue, 1);
        assertEquals(4, queue.getTail().intValue());
        assertEquals(3, queue.getHead().intValue());

        queue = createQueue();
        QueueUtils.rotateQueue(queue, 4);
        assertEquals(createQueue(), queue);
    }
}