package BasicLists;

public class CircleListObject implements IListObject {

    int centerX;
    int centerY;
    int radius;

    public CircleListObject(int x, int y, int radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    @Override
    public int compareTo(IListObject item) {
        return this.radius - ((CircleListObject)item).radius;
    }

    @Override
    public IListObject copy() {
        return new CircleListObject(centerX, centerY, radius);
    }

    @Override
    public String toString()
    {
        return "(" + centerX + ", " + centerY + ") " + radius;
    }
}
