package day3.abstract_interface.colorable_interface;

import day2.inheritance.shape.*;

public class Main {
    public static void main(String[] args){
        Shape[] shapes = new Shape[4];
        shapes[0] = new Square(2.3);    
        shapes[1] = new Circle(3.5);
        shapes[2] = new Rectangle(2.3, 5.8);
        shapes[3] = new Square(3.2);

        for (Shape shape : shapes){
            System.out.println(shape.toString());
            if (shape instanceof Colorable){
                ((Colorable)shape).howToColor();
            }
        }
    }
}
