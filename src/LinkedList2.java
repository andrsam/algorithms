import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        // здесь будет ваш код поиска
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                break;
            }
            node = node.next;
        }

        if (node == null) {
            return false;
        }

        removeSingleNode(node);

        return true;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        if (node == null) {
            return;
        }

        while (node != null) {
            if (node.value == _value) {
                removeSingleNode(node);
            }
            node = node.next;
        }

    }

    private void removeSingleNode(Node node) {
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

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count;
        for (count = 0; node != null; count++, node = node.next);
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            if (this.head == null) {
                addInTail(_nodeToInsert);
            } else {
                this.head.prev = _nodeToInsert;
                _nodeToInsert.next = this.head;
                this.head = _nodeToInsert;
            }
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next = _nodeToInsert;
            if (_nodeAfter == tail) {
                this.tail = _nodeToInsert;
            }
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}