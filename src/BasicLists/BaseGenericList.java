package BasicLists;

import java.io.PrintWriter;

public abstract class BaseGenericList {

    IListObject list[];

    int count;
    int maxItems;
    int pos;

    protected BaseGenericList() {
        list = new IListObject[100];
        maxItems = 100;
        count = 0;
        pos = 0;
    }

    protected BaseGenericList(int maxItems){
        list = new IListObject[maxItems];
        this.maxItems = maxItems;
        count = 0;
        pos = 0;
    }

    public boolean isFull()
    {
        return count >= maxItems;
    }

    public int lengthIs()
    {
        return count;
    }

    public void reset()
    {
        pos = 0;
    }

    public IListObject getNextItem()
    {
        return list[pos++ % (count)].copy();
    }

    public void printList(PrintWriter outFile)
    {
        for (int i = 0; i < count; i++)
        {
            outFile.println(list[i].toString());
        }
    }

    public abstract IListObject retrieve(IListObject item);

    public abstract boolean isThere(IListObject item);

    public abstract void insert(IListObject item);

    public abstract void delete(IListObject item);
}
