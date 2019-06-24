import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> storage;

    public Stack() {
        storage = new ArrayList<>();
    }

    public int size() {
        return storage.size();
    }

    public T pop() {
        if (storage.size() > 0) {
            return storage.remove(0);
        }
        return null;  // если стек пустой
    }

    public void push(T val) {
        storage.add(0, val);
    }

    public T peek() {
        if (storage.size() > 0) {
            return storage.get(0);
        }
        return null; // если стек пустой
    }
}