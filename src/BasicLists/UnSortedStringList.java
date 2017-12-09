package BasicLists;

import java.io.PrintWriter;

public class UnSortedStringList extends BaseStringList
{
    public UnSortedStringList() {
        super();
    }

    public UnSortedStringList(int maxItems) {
        super(maxItems);
    }

    public void insert(String item) {
        list[count] = new String(item);
        count++;
    }

    public void delete(String item) {
        for (int i = 0; i < count; i++) {
            if (list[i].compareTo(item) == 0) {
                list[i] = list[count - 1];
                count--;
                return;
            }
        }
    }
}
