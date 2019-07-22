import java.util.LinkedList;
import java.util.Objects;

public class Queue<T> {
    private LinkedList<T> storage;

    public Queue() {
        storage = new LinkedList<>();
    }

    public void enqueue(T item) {
        storage.addFirst(item);
    }

    public T dequeue() {
        if (storage.size() > 0) {
            // выдача из головы
            return storage.removeLast();
        }
        return null; // null если очередь пустая
    }

    public T getHead() {
        return storage.getLast();
    }

    public T getTail() {
        return storage.getFirst();
    }

    public int size() {
        return storage.size(); // размер очереди
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue<?> queue = (Queue<?>) o;

        if (queue.size() != storage.size()) {
            return false;
        }

        boolean isQueueElementsEquals = true;
        for (T element : storage) {
            if (!element.equals(queue.storage.peek())) {
                isQueueElementsEquals = false;
                break;
            }
        }

        return Objects.equals(storage, queue.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage);
    }
}