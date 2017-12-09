package LinkedList;

public class StringListItem implements IListItem {

    private String data;

    public StringListItem(String data){
        this.data = data;
    }

    @Override
    public int compareTo(IListItem item) {
        return data.compareTo(((StringListItem)item).data);
    }

    @Override
    public IListItem copy() {
        return new StringListItem(data);
    }

    @Override
    public String toString() {
        return data;
    }

}
