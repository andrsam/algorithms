import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class ReversedStackTest {
    private ReversedStack reversedStack = new ReversedStack();

    @Test
    public void size() {
        assertEquals(0, reversedStack.size());
        reversedStack.push(1);
        reversedStack.push("test");
        assertEquals(2, reversedStack.size());
    }

    @Test
    public void pop() {
        reversedStack.push(1);
        reversedStack.push(2);
        reversedStack.push(3);
        assertEquals(1, reversedStack.pop());
    }

    @Test
    public void push() {
        reversedStack.push(1);
        reversedStack.push(2);
        reversedStack.push(3);
        assertEquals(1, reversedStack.peek());
    }

    @Test
    public void peek() {
        reversedStack.push(1);
        assertEquals(1, reversedStack.peek());
    }
}