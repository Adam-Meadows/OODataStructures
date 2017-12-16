package PriorityQueue;

public interface PriQueueInterface {
    boolean isEmpty();

    boolean isFull();

    void enqueue(Comparable item);

    Comparable dequeue();
}
