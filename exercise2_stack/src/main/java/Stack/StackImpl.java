package Stack;


import java.util.ArrayDeque;
import java.util.Deque;

public class StackImpl<T> implements Stack<T> {

    private Deque<T> list = new ArrayDeque<>();

    @Override
    public void push(T o) {
        list.push(o);
    }

    @Override
    public T pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Throw an IllegalStateException");
        }
        return list.pop();
    }

    @Override
    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Throw an IllegalStateException");
        }
        return list.peek();
    }
}
