package Queue;

public class ArrayQueue implements IQueue {

    private Object queue[];
    private int frontIndex;
    private int rearIndex;
    private int count;
    private int maxItems;

    public ArrayQueue(){
        queue = new Object[100];
        maxItems = 100;
        rearIndex = -1;
        frontIndex = 0;
        count = 0;
    }

    public ArrayQueue(int maxItems){
        queue = new Object[maxItems];
        this.maxItems = maxItems;
        rearIndex = -1;
        frontIndex = 0;
        count = 0;
    }

    @Override
    public void enqueue(Object o) {
        rearIndex = (rearIndex + 1) % maxItems;

        queue[rearIndex] = o;
        count++;
    }

    @Override
    public Object dequeue(){
        Object next = queue[frontIndex];
        queue[frontIndex] = null;
        frontIndex = (frontIndex + 1) % maxItems;
        count--;

        return next;
    }


    // Fixed front design
//    @Override
//    public Object dequeue() {
//        Object next = queue[0];
//
//        for (int i = 0; i < count - 1; i++)
//            queue[i] = queue[i+1];
//
//        count--;
//
//        return next;
//    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == maxItems;
    }

    @Override
    public int count() {
        return count;
    }
}