package PriorityQueue;

public class Heap implements PriQueueInterface {

    private Comparable[] elements;

    private int lastIndex;
    private int maxIndex;

    public Heap(int maxSize){
        elements = new Comparable[maxSize];
        lastIndex = -1;
        maxIndex = maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public boolean isFull() {
        return lastIndex == maxIndex;
    }

    @Override
    public void enqueue(Comparable item) throws PriQOverflowException {
        if (isFull()){
            throw new PriQOverflowException("Priority queue is full.");
        } else {
            lastIndex++;
            reheapUp(item);
        }
    }

    private void reheapUp(Comparable item) {
        int hole = lastIndex;
        while (hole != 0 && item.compareTo(elements[(hole - 1)/2]) > 0){
            elements[hole] = elements[(hole - 1)/2];
            hole = (hole - 1)/2;
        }
        elements[hole] = item;
    }

    @Override
    public Comparable dequeue() {
        Comparable hold;
        Comparable toMove;

        if (lastIndex == -1){
            throw new PriQUnderflowException(("Priority queue is empty"));
        }else{
            hold = elements[0];
            toMove = elements[lastIndex];
            lastIndex--;
            reheapDown(toMove);
            return hold;
        }
    }

    private void reheapDown(Comparable item) {
        int hole = 0;
        int newhole;

        newhole = newHole(hole, item);
        while (newhole != hole){
            elements[hole] = elements[newhole];
            hole = newhole;
            newhole = newHole(hole, item);
        }
        elements[hole] = item;
    }

    private int newHole(int hole, Comparable item){
        int left = (hole *2)+1;
        int right = (hole * 2) + 2;

        if (left > lastIndex)
            return hole;
        else if (left == lastIndex)
            if (item.compareTo(elements[left]) < 0)
                return left;
            else
                return hole;
        else
            if (elements[left].compareTo(elements[0]) < 0)
                if (elements[right].compareTo(item) <= 0)
                    return hole;
                else
                    return right;
            else
                if (elements[left].compareTo(item) <= 0)
                    return hole;
                else
                    return left;
    }
}
