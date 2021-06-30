package day2.inheritance.moveable_point;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint point = new MoveablePoint(3.5F, 2.5F, 4.0F, 5.0F);
        System.out.println(point);

        MoveablePoint newPoint = point.move();
        System.out.println(newPoint);
    }
}
