package LinkedList;

public class UnsortedLinkedList extends BaseLinkedList {

    public UnsortedLinkedList(){
        super();
    }

    @Override
    public boolean contains(IListItem item) {
        ListNode iterator = first;

        while (iterator != null){
            if (iterator.data.compareTo(item) == 0)
                return true;
            iterator = iterator.next;
        }

        return false;
    }

    @Override
    public void insert(IListItem item) {
        ListNode newNode = new ListNode();
        newNode.data = item.copy();
        newNode.next = first;
        first = newNode;
        count++;
    }
}
