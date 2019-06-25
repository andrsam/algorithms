import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> storage;

    public Queue() {
        storage = new LinkedList<>();
    }

    public int size() {
        return storage.size();
    }

    public T pop() {
        if (storage.size() > 0) {
            return storage.removeFirst();
        }
        return null;  // если стек пустой
    }

    public void push(T val) {
        storage.add(val);
    }

    public T peek() {
        if (storage.size() > 0) {
            return storage.getFirst();
        }
        return null; // если стек пустой
    }
}