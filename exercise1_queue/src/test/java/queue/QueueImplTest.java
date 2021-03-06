package queue;

import org.junit.*;

import static org.junit.Assert.*;

public class QueueImplTest {

    @Test
    public void shouldEnqueueItems() {
        Queue<String> queue = new QueueImpl<>();
        queue.enqueue("AAA");
        queue.enqueue("BBB");
        queue.enqueue("CCC");

        assertEquals(3, queue.size());
    }

    @Test
    public void shouldDequeueItems() {
        Queue<String> queue = new QueueImpl<>();
        queue.enqueue("AAA");
        queue.enqueue("BBB");
        queue.enqueue("CCC");

        assertEquals(3, queue.size());

        String s = queue.dequeue();
        assertEquals("AAA", s);
        assertEquals(2, queue.size());

        s = queue.dequeue();
        assertEquals("BBB", s);
        assertEquals(1, queue.size());

        s = queue.dequeue();
        assertEquals("CCC", s);
        assertEquals(0, queue.size());
    }
}