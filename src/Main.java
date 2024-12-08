import classes.Coordinates;
import classes.Descriminant;
import classes.DivideNumerable;
import classes.Point;

public class Main {
    public static void main(String[] args) {

        Point<Integer> pointInt = new Point<>();
        pointInt.setCoord(10, 20);
        System.out.println("Координата X: " + pointInt.getCoord(Coordinates.COORD_X));
        System.out.println("Координата Y: " + pointInt.getCoord(Coordinates.COORD_Y));

        DivideNumerable<Integer> isDivided = x -> x % 13 == 0;
        System.out.println(isDivided.divide(52));
        System.out.println(isDivided.divide(72));

        Descriminant desc = (x, y, z) -> y*y - 4*x*z;
        System.out.println(desc.calculate(3, 3, 1.25));
        System.out.println(desc.calculate(10.8, 17.5, 6));
    }
}