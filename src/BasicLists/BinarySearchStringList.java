package BasicLists;

import static java.lang.Math.ceil;

@SuppressWarnings("Duplicates")
public class BinarySearchStringList extends BaseStringList {

    public BinarySearchStringList(int maxItems) {
        super(maxItems);
    }

    public BinarySearchStringList() {
        super();
    }

    public boolean isThere(String item) {

        int midpoint = count / 2;
        int lowerBound = 0;
        int upperBound = count - 1;
        int cmp;

        while (lowerBound <= upperBound) {
            cmp = list[midpoint].compareTo(item);
            if (cmp > 0) {
                upperBound = midpoint - 1;
            } else if (cmp < 0) {
                lowerBound = midpoint + 1;
            } else {
                return true;
            }
            midpoint = (upperBound + lowerBound) / 2;
        }

        return false;
    }

    public void insert(String item) {
        int midpoint = count / 2;
        int lowerBound = 0;
        int upperBound = count;
        int cmp;

        while (lowerBound < upperBound) {
            cmp = list[midpoint].compareTo(item);
            if (cmp > 0) {
                upperBound = midpoint;
            } else if (cmp < 0) {
                lowerBound = midpoint + 1;
            }
            midpoint = (upperBound + lowerBound) / 2;
        }

        for (int j = count; j > midpoint; j--) {
            list[j] = list[j - 1];
        }

        list[midpoint] = item;
        count++;
    }

    public void delete(String item) {
        int midpoint = count / 2;
        int lowerBound = 0;
        int upperBound = count - 1;
        int cmp;

        while (lowerBound <= upperBound) {
            cmp = list[midpoint].compareTo(item);
            if (cmp > 0) {
                upperBound = midpoint - 1;
            } else if (cmp < 0) {
                lowerBound = midpoint + 1;
            } else {
                break;
            }
            midpoint = (upperBound + lowerBound) / 2;
        }

        for (int j = midpoint; j < count - 1; j++) {
            list[j] = list[j + 1];
        }

        count--;
    }

}
