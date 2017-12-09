package BasicLists;

import static java.lang.Math.ceil;

@SuppressWarnings("Duplicates")
public class SortedGenericList extends BaseGenericList {

    public SortedGenericList(){
        super();
    }

    public SortedGenericList(int maxItems){
        super(maxItems);
    }

    @Override
    public IListObject retrieve(IListObject item) {

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
                return list[midpoint].copy();
            }
            midpoint = (upperBound + lowerBound) / 2;
        }

        return null;
    }

    @Override
    public boolean isThere(IListObject item) {
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

    @Override
    public void insert(IListObject item) {
        int midpoint = count / 2;
        int lowerBound = 0;
        int upperBound = count;
        int cmp;

        while (lowerBound < upperBound && count != 0) {
            cmp = list[midpoint].compareTo(item);
            if (cmp > 0) {
                upperBound = midpoint;
            } else if (cmp < 0) {
                lowerBound = midpoint + 1;
            }
            midpoint = (upperBound + lowerBound)/ 2;
        }

        for (int j = count; j > midpoint; j--) {
            list[j] = list[j - 1];
        }

        list[midpoint] = item.copy();
        count++;
    }

    @Override
    public void delete(IListObject item) {
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
