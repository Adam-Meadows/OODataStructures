package LinkedList;

public class SortedLinkedList extends BaseLinkedList {

    public SortedLinkedList(){
        super();
    }

    @Override
    public boolean contains(IListItem item) {
        ListNode iterator = first;

        while (iterator != null){
            if (item.compareTo(iterator.data) == 0){
                return true;
            } else if (item.compareTo(iterator.data) < 0){
                return false;
            }
            iterator = iterator.next;
        }

        return false;
    }

    @Override
    public void insert(IListItem item) {

        if (isEmpty()){
            first = new ListNode();
            first.data = item;
            first.next = null;
            count++;
            return;
        }

        ListNode iterator = new ListNode();

        iterator.next = first;

        while (iterator.next != null && item.compareTo(iterator.next.data) > 0){
            iterator = iterator.next;
        }

        ListNode newNode = new ListNode();
        newNode.data = item;
        newNode.next = iterator.next;
        iterator.next = newNode;

        if (newNode.next == first) first = newNode;

        count++;
    }
}
