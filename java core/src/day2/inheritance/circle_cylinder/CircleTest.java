package day2.inheritance.circle_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5, "red");
        System.out.println(circle);
    }
}
