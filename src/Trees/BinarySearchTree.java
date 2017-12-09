package Trees;
import Queue.ArrayQueue;
import Stack.LinkedStack;

public class BinarySearchTree implements BSTInterface {

    protected class BSTNode {
        protected Comparable info;
        protected BSTNode left;
        protected BSTNode right;
    }

    protected BSTNode root;

    public BinarySearchTree(){
        root = null;
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numberOfNodes() {
        return recNumberOfNodes(root);
    }

    private int recNumberOfNodes(BSTNode currentNode){
        if (currentNode == null) return 0;

        return recNumberOfNodes(currentNode.right) + recNumberOfNodes(currentNode.left) + 1;
    }

    private int iterNumberOfNodes(){
        if (isEmpty()) return 0;
        LinkedStack stack = new LinkedStack();
        stack.push(root);

        int count = 0;
        BSTNode currentNode;
        while (!stack.isEmpty()){
            currentNode = (BSTNode)stack.top();
            stack.pop();
            count++;

            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }

        return count;
    }

    @Override
    public boolean isThere(Comparable item) {
        Temp = item;
        return recIsThere(root);
    }

    private Comparable Temp;

    private boolean recIsThere(BSTNode currentNode){
        if (currentNode == null) return false;
        int compare = Temp.compareTo(currentNode.info);
        if (compare < 0) return recIsThere(currentNode.left);
        if (compare > 0) return recIsThere(currentNode.right);
        return true;
    }

    @Override
    public Comparable retrieve(Comparable item) {
        Temp = item;
        return recRetrieve(root);
    }

    private Comparable recRetrieve(BSTNode currentNode){
        int compare = Temp.compareTo(currentNode.info);
        if (compare < 0) return recRetrieve(currentNode.left);
        if (compare > 0) return recRetrieve(currentNode.right);
        return currentNode.info;
    }

    @Override
    public void insert(Comparable item) {
        Temp = item;
        root = recInsert(root);
    }

    private BSTNode recInsert(BSTNode currentNode){
        if (currentNode == null){
            BSTNode newNode = new BSTNode();
            newNode.info = Temp;
            return newNode;
        }
        int compare = Temp.compareTo(currentNode.info);
        if (compare < 0) currentNode.left = recInsert(currentNode.left);
        if (compare > 0) currentNode.right = recInsert(currentNode.right);

        return currentNode;
    }

    @Override
    public void delete(Comparable item){
        root = recDelete(root, item);
    }

    private BSTNode recDelete(BSTNode currentNode, Comparable item){
        int compare = item.compareTo(currentNode.info);
        if (compare < 0) currentNode.left = recDelete(currentNode.left, item);
        if (compare > 0) currentNode.right = recDelete(currentNode.right, item);
        currentNode = deleteNode(currentNode);
        return currentNode;
    }

    private BSTNode deleteNode(BSTNode currentNode){
        if (currentNode == null) return null;
        if (currentNode.right == null) return currentNode.left;
        if (currentNode.left == null) return currentNode.right;
        currentNode.info = getPredecessor(currentNode.left);
        currentNode.left = recDelete(currentNode.left, currentNode.info);
        return currentNode;
    }

    private Comparable getPredecessor(BSTNode currentNode){
        while (currentNode.right != null)
            currentNode = currentNode.right;
        return currentNode.info;
    }

    protected ArrayQueue inOrderQueue;
    protected ArrayQueue preOrderQueue;
    protected ArrayQueue postOrderQueue;

    @Override
    public int reset(int orderType) {
        int numNodes = numberOfNodes();
        
        if (orderType == INORDER){
            inOrderQueue = new ArrayQueue();
            inOrder(root);
        }
        else if (orderType == PREORDER){
            preOrderQueue = new ArrayQueue();
            preOrder(root);
        }
        else if (orderType == POSTORDER){
            postOrderQueue = new ArrayQueue();
            postOrder(root);
        }
        return numNodes;
    }

    private void preOrder(BSTNode currentNode) {
        if (currentNode != null){
            preOrderQueue.enqueue(currentNode.info);
            preOrder(currentNode.left);
            preOrder(currentNode.right);
        }
    }

    private void inOrder(BSTNode currentNode) {
        if (currentNode != null){
            inOrder(currentNode.left);
            inOrderQueue.enqueue(currentNode.info);
            inOrder(currentNode.right);
        }
    }

    private void postOrder(BSTNode currentNode) {
        if (currentNode != null){
            postOrder(currentNode.left);
            postOrder(currentNode.right);
            postOrderQueue.enqueue(currentNode.info);
        }
    }

    @Override
    public Comparable getNextItem(int orderType) {
        if (orderType == INORDER) return (Comparable) inOrderQueue.dequeue();
        if (orderType == PREORDER) return (Comparable) preOrderQueue.dequeue();
        if (orderType == POSTORDER) return (Comparable) postOrderQueue.dequeue();
        return null;
    }

    private Comparable nodeArray[];

    @Override
    public BinarySearchTree balance() {
        BinarySearchTree balancedTree = new BinarySearchTree();
        int count = reset(INORDER);
        balancedTree.nodeArray = new Comparable[count];
        for (int i = 0; i < count; i++) {
            balancedTree.nodeArray[i] = getNextItem(INORDER);
        }

        balancedTree.insertTree(0, count - 1);

        return balancedTree;
    }

    @Override
    public Comparable find(Comparable item) {
        Temp = item;
        return recFind(root);
    }

    private Comparable recFind(BSTNode currentNode) {
        if (currentNode == null) return null;
        int compare = Temp.compareTo(currentNode.info);
        if (compare < 0) return recFind(currentNode.left);
        if (compare > 0) return recFind(currentNode.right);
        return currentNode.info;
    }

    private void insertTree(int low, int high) {
        if (low == high) insert(nodeArray[low]);
        else if (low + 1 == high){
            insert(nodeArray[low]);
            insert(nodeArray[high]);
        }
        else {
            int mid = (low + high) / 2;
            insert(nodeArray[mid]);
            insertTree(low, mid - 1);
            insertTree(mid + 1, high);
        }
    }
}
