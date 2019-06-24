import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class StackTest {
    public static final String TEST = "test";
    private Stack stack = new Stack();


    @Test
    public void size() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push("test");
        assertEquals(2, stack.size());
    }

    @Test

    public void pop() {
        stack.push(TEST);
        stack.push(1);
        assertEquals(2, stack.size());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    public void push() {
        stack.push(TEST);
        stack.push(1);
        assertEquals(2, stack.size());
    }

    @Test
    public void peek() {
        stack.push(TEST);
        assertEquals(TEST, stack.peek());
    }
}