package BasicLists;

import java.io.PrintWriter;

public abstract class BaseStringList
{
    protected String list[];
    protected int maxItems;
    protected int count;
    protected int pos;

    public BaseStringList(int maxItems)
    {
        this.maxItems = maxItems;
        list = new String[maxItems];
        count = 0;
    }

    public BaseStringList()
    {
        this.maxItems = 100;
        list = new String[100];
        count = 0;
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

    public String getNextItem()
    {
        return new String(list[pos++ % (count)]);
    }

    public void printList(PrintWriter outFile)
    {
        for (int i = 0; i < count; i++)
        {
            outFile.println(list[i]);
        }
    }
}
