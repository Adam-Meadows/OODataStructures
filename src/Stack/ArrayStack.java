package Stack;

public class ArrayStack implements IStack{

    private Object stack[];
    private int topIndex;
    private int maxItems;

    public ArrayStack(){
        stack = new Object[100];
        maxItems = 100;
        topIndex = -1;
    }

    public ArrayStack(int maxItems){
        stack = new Object[maxItems];
        this.maxItems = maxItems;
        topIndex = -1;
    }

    @Override
    public void clear(){
        while(!isEmpty())
            pop();
    }

    @Override
    public int count(){
        return topIndex + 1;
    }

    @Override
    public void push(Object o) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException("Stack overflow (push)");

        stack[++topIndex] = o;
    }

    @Override
    public void pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Stack underflow (pop)");

        stack[topIndex--] = null;
    }

    @Override
    public Object top() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Stack underflow (top)");
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == maxItems - 1;
    }
}
