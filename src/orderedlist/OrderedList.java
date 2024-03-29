package orderedlist;

import java.util.ArrayList;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }

}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    private static final String DATATYPE_STRING = "java.lang.String";
    private static final String DATATYPE_INTEGER = "java.lang.Integer";

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 == null) {
            return -1;
        }
        int cmp = 0;
        switch (v1.getClass().getName()) {
            case DATATYPE_STRING:
                cmp = ((String) v1).trim().compareTo(((String) v2).trim());
                break;
            case DATATYPE_INTEGER:
                cmp = ((Integer) v1).compareTo((Integer) v2);
                break;
        }
        return cmp * getSortOrder();
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            this.head = newNode;
            this.tail = this.head;
            this.head.next = null;
            this.head.prev = null;
        } else {
            Node<T> prevNode = head;
            while (prevNode.next != null && compare(prevNode.value, value) < 0) {
                prevNode = prevNode.next;
            }
            //[newNode, prevNode]
            if (compare(prevNode.value, value) > 0) {
                newNode.next = prevNode;
                if (prevNode == head) {
                    head = newNode;
                } else {
                    prevNode.prev.next = newNode;
                }
                prevNode.prev = newNode;
            } else {
                newNode.prev = prevNode;
                if (prevNode == tail) {
                    tail = newNode;
                    newNode.next = null;
                } else {
                    newNode.next = prevNode.next;
                    prevNode.next.prev = newNode;
                }
                prevNode.next = newNode;
            }
        }

    }

    @SuppressWarnings("unchecked")
    public Node<T> find(T val) {
        if (head == null) {
            return null;
        }

        if (head.value.equals(val)) {
            return head;
        }

        Node node = head;
        while (node != null && node.value != val) {
            node = node.next;

            if (compare((T) node.value, val) > 0) {
                node = null;
                break;
            }
        }
        return node;
    }

    public void delete(T val) {
        Node node = this.head;

        while (node != null) {
            if (node.value == val) {
                break;
            }
            node = node.next;
        }

        if (node == null) {
            return;
        }

        if (node == this.head) {
            this.head = node.next;
            if (this.head == null) {
                this.tail = null;
            } else {
                this.head.prev = null;
            }
        } else if (node == this.tail) {
            this.tail = node.prev;
            this.tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count;
        for (count = 0; node != null; count++, node = node.next) ;
        return count;
    }

    ArrayList<Node<T>> getAll() {
        // выдать все элементы упорядоченного
        // списка в виде стандартного списка
        ArrayList<Node<T>> r = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public String asString() {
        if (head == null) {
            return "";
        }
        return getAll().stream().map(n -> String.valueOf(n.value)).collect(java.util.stream.Collectors.joining(","));
    }

    private int getSortOrder() {
        return _ascending ? 1 : -1;
    }
}