package Stack;

public class LinkedStack implements IStack {

    StackNode top;
    int count;

    public LinkedStack(){
        top = null;
        count = 0;
    }

    @Override
    public void push(Object o) throws StackOverflowException {
        StackNode newNode = new StackNode();
        newNode.info = o;
        newNode.link = top;
        top = newNode;
        count++;
    }

    @Override
    public void pop() throws StackUnderflowException {
        if (!isEmpty()) {
            top = top.link;
            count--;
        }
        else throw new StackUnderflowException("pop");
    }

    @Override
    public Object top() throws StackUnderflowException {
        if (!isEmpty()) {
            return top.info;
        }
        else throw new StackUnderflowException("top");
    }

    @Override
    public void clear() {
        top = null;

        count = 0;
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
    public boolean isFull() {
        return false;
    }



    private class StackNode{
        private Object info;
        private StackNode link;
    }
}
