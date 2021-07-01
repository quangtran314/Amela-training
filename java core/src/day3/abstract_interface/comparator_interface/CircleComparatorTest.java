package day3.abstract_interface.comparator_interface;

import java.util.Arrays;
import java.util.Comparator;

import day2.inheritance.shape.Circle;

public class CircleComparatorTest {
    public static void main(String[] args){
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator<Circle> circleComparator = new Comparator<Circle>(){
            public int compare(Circle c1, Circle c2){
                if (c1.getRadius() > c2.getRadius()) return 1;
                else if (c1.getRadius() < c2.getRadius()) return -1;
                else return 0;
            }
        };
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
