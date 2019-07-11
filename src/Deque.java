import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> storage;

    public Deque() {
        // инициализация внутреннего хранилища
        storage = new LinkedList<>();
    }

    public void addFront(T item) {
        // добавление в голову
        storage.addFirst(item);
    }

    public void addTail(T item) {
        // добавление в хвост
        storage.addLast(item);
    }

    public T removeFront() {
        // удаление из головы
        return storage.size() == 0 ? null : storage.removeFirst();
    }

    public T removeTail() {
        // удаление из хвоста
        return storage.size() == 0 ? null : storage.removeLast();
    }

    public T getHead() {
        return storage.getFirst();
    }

    public T getTail() {
        return storage.getLast();
    }

    public int size() {
        return storage.size(); // размер очереди
    }
}