public class DoubleStackQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public DoubleStackQueue() {
        // инициализация внутреннего хранилища очереди
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        // вставка в хвост
        stack1.push(item);
    }

    public T dequeue() {
        // null если очередь пустая
        if (stack1.size() == 0) {
            return null;
        }
        // выдача из головы
        T result = null;
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        result = stack1.pop();

        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
