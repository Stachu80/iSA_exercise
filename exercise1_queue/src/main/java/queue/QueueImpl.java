package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueImpl<T> implements Queue<T> {

    /*This class is likely to be faster than
     * {@link Stack} when used as a stack, and faster than {@link LinkedList}
     * when used as a queue.
     * */

    private Deque<T> queue = new ArrayDeque<>();

    @Override
    public void enqueue(T o) {
        queue.add(o);
    }

    @Override
    public T dequeue() {
        return queue.remove();
    }

    @Override
    public int size() {
        return queue.size();
    }

}






