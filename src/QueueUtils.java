public class QueueUtils {
    public static <E> void rotateQueue(Queue<E> queue, int n) {
        if (queue.size() <= 1 || n <= 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            E head = queue.dequeue();
            queue.enqueue(head);
        }
    }
}
