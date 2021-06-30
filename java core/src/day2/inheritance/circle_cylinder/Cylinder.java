package day2.inheritance.circle_cylinder;

public class Cylinder extends Circle{
    private double heigh;

    public Cylinder(){
        super();
        this.heigh = 3.0;
    }

    public Cylinder(double radius, String color, double heigh){
        super(radius, color);
        this.heigh = heigh;
    }
    
    public double getHeigh(){
        return this.heigh;
    }

    public void setHeigh(double heigh){
        this.heigh = heigh;
    }

    public double getArea(){
        return 2 * Math.PI * this.getRadius() * this.heigh + 2 * Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double getVolume(){
        return Math.PI * Math.pow(this.getRadius(), 2) * this.heigh;
    }

    @Override
    public String toString() {
        return "A Cylinder with radius="
                + getRadius()
                + ", heigh = "
                + getHeigh()
                + ", color = "
                + getColor()
                + ", which is a subclass of "
                + super.toString();
    }
}
