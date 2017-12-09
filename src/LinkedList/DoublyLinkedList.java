package LinkedList;

public class DoublyLinkedList implements IList {

    private class DoubleListNode{
        IListItem data;
        DoubleListNode next;
        DoubleListNode prev;
    }

    DoubleListNode first;
    int count;


    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean contains(IListItem item) {
        return false;
    }

    @Override
    public IListItem retrieve(IListItem item) {
        return null;
    }

    @Override
    public void insert(IListItem item) {

    }

    @Override
    public void delete(IListItem item) {

    }

    @Override
    public void reset() {

    }

    @Override
    public IListItem getNextItem() {
        return null;
    }
}
