package LinkedList;

public class CircularSortedLinkedList extends BaseLinkedList {

    public CircularSortedLinkedList(){
        super();
    }

    @Override
    public boolean contains(IListItem item){
        if (isEmpty()) return false;
        //if (first.next.data.compareTo(item) == 0) return true;

        ListNode n = first;

        do{
            n = n.next;
            if (item.compareTo(n.data) == 0) return true;
            if (item.compareTo(n.data) < 0) return false;
        }
        while(n != first);

        return false;
    }

    @Override
    public void delete(IListItem item){
        ListNode iterator = first;

        while(iterator.next.data.compareTo(item) != 0){
            iterator = iterator.next;
        }

        if (iterator.next == first) first = iterator;

        iterator.next = iterator.next.next;
        count--;
    }

    @Override
    public void reset(){
        if (first == null){
            current = null;
            return;
        }
        current = first.next;
    }

    @Override
    public IListItem getNextItem(){
        IListItem next = current.data.copy();
        current = current.next;
        return next;
    }

    @Override
    public void insert(IListItem item) {

        count++;
        if (first == null)
        {
            first = new ListNode();
            first.data = item;
            first.next = first;
            return;
        }

        ListNode iterator = first;
        ListNode newNode = new ListNode();
        if (iterator.next.data.compareTo(item) <= 0) {
            first = newNode;
        } else{
            do {
                if (iterator.next.data.compareTo(item) > 0) break;
                iterator = iterator.next;
            } while (iterator!=first);
        }

        newNode.data = item;
        newNode.next = iterator.next;
        iterator.next = newNode;
    }
}
