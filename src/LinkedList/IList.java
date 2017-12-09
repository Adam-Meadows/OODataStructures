package LinkedList;

public interface IList {

    boolean isFull();

    boolean isEmpty();

    int count();

    boolean contains(IListItem item);

    IListItem retrieve(IListItem item);

    void insert(IListItem item);

    void delete(IListItem item);

    void reset();

    IListItem getNextItem();

}
