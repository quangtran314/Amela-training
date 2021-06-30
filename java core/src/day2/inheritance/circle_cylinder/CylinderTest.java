package day2.inheritance.circle_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3.5, "red", 4.0);
        System.out.println(cylinder);
    }
}
