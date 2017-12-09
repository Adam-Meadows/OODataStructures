package Queue;

import Stack.StackUnderflowException;

public class LinkedQueue implements IQueue {

    private QueueNode last;
    private QueueNode first;
    private int count;

    public LinkedQueue(){
        last = null;
        first = null;
        count = 0;
    }

    @Override
    public void enqueue(Object o) {
        QueueNode newNode = new QueueNode();
        newNode.info = o;
        newNode.next = null;

        if (!isEmpty()){
            last.next = newNode;
            last = newNode;
        }
        else{
            first = newNode;
            last = newNode;
        }

        count++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) throw new StackUnderflowException("dequeue");

        Object result = first.info;
        first = first.next;
        count--;

        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int count() {
        return count;
    }

    public class QueueNode{
        Object info;
        QueueNode next;
    }
}