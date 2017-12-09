package Trees;

public interface BSTInterface {
    int PREORDER = 1;
    int INORDER = 2;
    int POSTORDER = 3;

    boolean isEmpty();

    boolean isFull();

    int numberOfNodes();

    boolean isThere(Comparable item);

    Comparable retrieve(Comparable item);

    void insert(Comparable item);

    void delete(Comparable item);

    int reset(int orderType);

    Comparable getNextItem(int orderType);

    BSTInterface balance();

    Comparable find(Comparable item);
}
