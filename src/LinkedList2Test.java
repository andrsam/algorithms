import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedList2Test {
    private LinkedList2 bigList = new LinkedList2();

    private LinkedList2 smallList = new LinkedList2();

    private LinkedList2 emptyList = new LinkedList2();


    @Before
    public void setUp() {
        bigList.clear();
        bigList.addInTail(new Node(1));
        bigList.addInTail(new Node(5));
        bigList.addInTail(new Node(2));
        bigList.addInTail(new Node(1));
        bigList.addInTail(new Node(1));
        bigList.addInTail(new Node(2));
        bigList.addInTail(new Node(9));

        smallList.clear();
        smallList.addInTail(new Node(1));
    }

    @Test
    public void find() {
        Node node = bigList.find(9);
        assertEquals(node.value, 9);

        node = bigList.find(-1);
        assertNull(node);

        node = smallList.find(1);
        assertEquals(1, node.value);

        node = emptyList.find(22);
        assertNull(node);
    }


    @Test
    public void findAll() {
        assertEquals(3, bigList.findAll(1).size());
        assertEquals(1, bigList.findAll(9).size());
        assertTrue(bigList.findAll(-1).isEmpty());
        assertEquals(1, smallList.findAll(1).size());
        assertTrue(emptyList.findAll(1).isEmpty());
    }


    @Test
    public void remove() {
        // [1, 5, 2, 1, 1, 2, 9]
        bigList.remove(1);
        assertEquals(5, bigList.head.value);
        assertEquals(2, bigList.head.next.value);
        assertEquals(bigList.head, bigList.head.next.prev);
        assertNull(bigList.head.prev);

        assertEquals(9, bigList.tail.value);
        assertEquals(2, bigList.tail.prev.value);
        assertEquals(bigList.tail, bigList.tail.prev.next);
        assertNull(bigList.tail.next);

        //[5, 2, 1, 1, 2, 9] -> [5, 1, 1, 2, 9]
        bigList.remove(2);
        assertEquals(5, bigList.head.value);
        assertNull(bigList.head.prev);
        assertEquals(1, bigList.head.next.value);
        assertEquals(9, bigList.tail.value);
        assertEquals(2, bigList.tail.prev.value);
        assertNull(bigList.tail.next);

        bigList.remove(9);
        //{5, 1, 1, 2}
        assertEquals(5, bigList.head.value);
        assertNull(bigList.head.prev);
        assertEquals(1, bigList.head.next.value);
        assertEquals(2, bigList.tail.value);
        assertEquals(1, bigList.tail.prev.value);
        assertNull(bigList.tail.next);


        //[1]
        assertFalse(smallList.remove(5));
        assertTrue(smallList.remove(1));
        assertNull(smallList.head);
        assertNull(smallList.tail);

        //[]
        assertFalse(emptyList.remove(5));
    }

    @Test
    public void removeAll() {
        // [1, 5, 2, 1, 1, 2, 9] -> [5, 2, 2, 9]
        bigList.removeAll(1);
        assertEquals(5, bigList.head.value);
        assertEquals(2, bigList.head.next.value);
        assertEquals(bigList.head, bigList.head.next.prev);
        assertNull(bigList.head.prev);
        assertEquals(9, bigList.tail.value);
        assertEquals(bigList.tail, bigList.tail.prev.next);
        assertNull(bigList.tail.next);

        //[5, 2, 2, 9] -> [5, 9]
        bigList.removeAll(2);
        assertEquals(5, bigList.head.value);
        assertNull(bigList.head.prev);
        assertEquals(bigList.head, bigList.head.next.prev);
        assertEquals(9, bigList.head.next.value);
        assertEquals(9, bigList.tail.value);
        assertEquals(bigList.tail, bigList.tail.prev.next);
        assertNull(bigList.tail.next);

        //[5,9] -> [5]
        bigList.removeAll(9);
        assertEquals(5, bigList.head.value);
        assertEquals(5, bigList.tail.value);
        assertNull(bigList.tail.next);
        assertNull(bigList.tail.prev);

        bigList.removeAll(5);
        assertNull(bigList.head);
        assertNull(bigList.tail);
    }


    @Test
    public void clear() {
        bigList.clear();
        assertNull(bigList.head);
        assertNull(bigList.tail);
    }


    @Test
    public void count() {
        assertEquals(7, bigList.count());
        assertEquals(1, smallList.count());
        assertEquals(0, emptyList.count());
    }


    @Test
    public void insertAfter() {
        //в начало непустого списка
        Node nodeToInsert = new Node(7);
        bigList.insertAfter(null, nodeToInsert);
        //{7, 1, 5, 2, 1, 1, 2, 9}
        assertEquals(7, bigList.head.value);
        assertEquals(bigList.head, bigList.head.next.prev);
        assertNull(bigList.head.prev);
        assertEquals(1, bigList.head.next.value);

        assertEquals(9, bigList.tail.value);
        assertEquals(bigList.tail, bigList.tail.prev.next);

        //после головы
        Node nodeToInsert1 = new Node(3);
        Node nodeAfter1 = bigList.head;
        bigList.insertAfter(nodeAfter1, nodeToInsert1);
        //{7, 3, 1, 5, 2, 1, 1, 2, 9}
        assertEquals(7, bigList.head.value);
        assertEquals(3, bigList.head.next.value);
        assertEquals(9, bigList.tail.value);
        assertEquals(nodeAfter1.next, nodeToInsert1);
        assertEquals(nodeAfter1, nodeToInsert1.prev);
        assertEquals(bigList.tail, bigList.tail.prev.next);

        //после хвоста
        Node nodeAfter2 = bigList.tail;
        Node nodeToInsert2 = new Node(10);
        bigList.insertAfter(nodeAfter2, nodeToInsert2);
        //assertArrayEquals(new int[]{7, 3, 1, 5, 2, 1, 1, 2, 9, 10}, bigList.toArray());
        assertEquals(7, bigList.head.value);
        assertEquals(3, bigList.head.next.value);
        assertEquals(bigList.head, bigList.head.next.prev);

        assertEquals(10, bigList.tail.value);
        assertEquals(9, bigList.tail.prev.value);
        assertEquals(bigList.tail, bigList.tail.prev.next);
        assertEquals(nodeAfter2.next, nodeToInsert2);
        assertEquals(nodeAfter2, nodeToInsert2.prev);

        //на произвольную позицию в списке
        Node nodeAfter4 = bigList.find(5);
        Node nodeToInsert4 = new Node(77);
        bigList.insertAfter(nodeAfter4, nodeToInsert4);
        //assertArrayEquals(new int[]{7, 3, 1, 5, 77, 2, 1, 1, 2, 9, 11, 10}, bigList.toArray());
        assertEquals(7, bigList.head.value);
        assertEquals(3, bigList.head.next.value);
        assertEquals(10, bigList.tail.value);
        assertEquals(nodeAfter4.next, nodeToInsert4);
        assertEquals(nodeAfter4, nodeToInsert4.prev);

        //список из одного элемента, на первую позицию
        smallList.insertAfter(null, new Node(5));
        //{5, 1}
        assertEquals(5, smallList.head.value);
        assertEquals(1, smallList.head.next.value);
        assertEquals(1, smallList.tail.value);
        assertEquals(5, smallList.tail.prev.value);
        assertNull(smallList.tail.next);


        //пустой список
        emptyList.insertAfter(null, new Node(5));
        //assertArrayEquals(new int[]{5}, emptyList.toArray());
        assertEquals(5, emptyList.head.value);
        assertEquals(5, emptyList.tail.value);
    }
}