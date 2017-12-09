package Queue;

public interface IQueue {

    void enqueue(Object o);

    Object dequeue();

    boolean isEmpty();

    boolean isFull();

    int count();

}