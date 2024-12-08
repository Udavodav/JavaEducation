package classes;

public class Point<T> implements Cooordinatable<T>  {

    private T x;
    private T y;

    @Override
    public void setCoord(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public T getCoord(Coordinates type) {
        return type == Coordinates.COORD_X ? x : y;
    }
}
