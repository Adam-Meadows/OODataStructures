package Stack;


public interface IStack {

    void push(Object o) throws StackOverflowException;

    void pop() throws StackUnderflowException;

    Object top() throws StackUnderflowException;

    void clear();

    int count();

    boolean isEmpty();

    boolean isFull();
}
