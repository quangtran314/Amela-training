package day2.inheritance.moveable_point;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(3.5F, 2.5F);
        System.out.println(point);
    }
}
