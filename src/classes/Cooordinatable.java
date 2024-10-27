package classes;

public interface Cooordinatable<T> {
    void setCoord(T x, T y);
    T getCoord(Coordinates type);
}
