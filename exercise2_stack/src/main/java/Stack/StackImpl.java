package Stack;


import java.util.ArrayDeque;
import java.util.Deque;

public class StackImpl<T> implements Stack<T> {

    private Deque<T> stack = new ArrayDeque<>();

    @Override
    public void push(T o) {
        stack.push(o);
    }

    @Override
    public T pop() {
        if (stack.size() == 0) {
            throw new IllegalStateException("Throw an IllegalStateException");
        }
        return stack.pop();
    }

    @Override
    public T peek() {
        if (stack.size() == 0) {
            throw new IllegalStateException("Throw an IllegalStateException");
        }
        return stack.peek();
    }
}
