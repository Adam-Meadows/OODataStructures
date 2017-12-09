package BasicLists;

public class SortedStringList extends BaseStringList {

    public SortedStringList(int maxItems) {
        super(maxItems);
    }

    public SortedStringList() {
        super();
    }

    public boolean isThere(String item) {
        for (int i = 0; i < count; i++) {
            if (list[i].compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    public void insert(String item) {
        int i;
        for (i = 0; i < count; i++) {
            if (list[i].compareTo(item) > 0) {
                break;
            }
        }

        for (int j = count; j > i; j--) {
            list[j] = list[j - 1];
        }

        list[i] = item;
        count++;
    }

    public void delete(String item) {
        int i = 0;
        for (i = 0; i < count; i++) {
            if (list[i].compareTo(item) == 0) {
                break;
            }
        }

        for (int j = i; j < count - 1; j++) {
            list[j] = list[j + 1];
        }

        count--;
    }
}

