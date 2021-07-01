package day3.abstract_interface.comparator_interface;

import java.util.Comparator;

import day2.inheritance.shape.Circle;

public class CircleComparator implements Comparator<Circle>{

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
    
}
