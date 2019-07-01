import java.util.LinkedList;

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
            return storage.getLast();
        }
        return null; // null если очередь пустая
    }

    public int size() {
        return storage.size(); // размер очереди
    }

}