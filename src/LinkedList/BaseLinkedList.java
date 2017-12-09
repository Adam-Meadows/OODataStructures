package LinkedList;

public abstract class BaseLinkedList implements IList {

    protected int count;
    protected ListNode current;
    protected ListNode first;

    protected BaseLinkedList(){
        count = 0;
        current = null;
        first = null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void reset() {
        current = first;
    }

    @Override
    public IListItem getNextItem() {
        IListItem result = current.data;
        current = current.next;
        return result.copy();
    }

    @Override
    public IListItem retrieve(IListItem item) {

        ListNode iterator = first;
        while (iterator.data.compareTo(item) != 0){
            iterator = iterator.next;
        }

        return iterator.data.copy();
    }

    @Override
    public void delete(IListItem item) {

        count--;
        if (first.data.compareTo(item) == 0){
            first = first.next;
            return;
        }

        ListNode iterator = first;
        while (iterator.next.data.compareTo(item) != 0){
            iterator = iterator.next;
        }

        iterator.next = iterator.next.next;
    }

    @Override
    public abstract boolean contains(IListItem item);

    @Override
    public abstract void insert(IListItem item);

    protected class ListNode{
        IListItem data;
        ListNode next;
    }
}