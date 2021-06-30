package day2.inheritance.moveable_point;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0F;
    private float ySpeed = 0.0F;

    public MoveablePoint(){

    }

    public MoveablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] speed = new float[2];
        speed[0] = this.getXSpeed();
        speed[1] = this.getXSpeed();
        return speed;
    }

    @Override
    public String toString(){
        return super.toString()
               + ", speed = ("
               + this.getXSpeed()
               + ", "
               + this.getYSpeed()
               + ")";
    }

    public MoveablePoint move(){
        this.setX(this.getX() + xSpeed);
        this.setY(this.getY() + ySpeed);
        return this;
    }
}
