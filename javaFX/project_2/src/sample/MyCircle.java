package sample;
import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyOval {
    double w, h;
    public MyCircle(double x, double y, double w, double h, MyColor color) {
        super(x, y, color);
        this.w = w;
        this.h = h;
    }
    public double getRadius() {
        return w*h;
    }
    public double getArea() {
        return (Math.PI)* Math.pow(getRadius(),2);
    }
    public double getPerimeter() {
        return (Math.PI)*(2*getRadius());
    }
    @Override
    public String toString() {
        return "The circle has a radius of " + this.getRadius() + " with a perimeter of " + this.getPerimeter() +
                " and an area of " + this.getArea();
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(super.getColor().getMyColor());
        gc.strokeOval(super.getX(), super.getY(),getRadius(), getRadius());
        gc.fillOval(super.getX(), super.getY(),getRadius(), getRadius());
    }
    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rectangle = new MyRectangle(super.getX(),super.getY(),w,h,MyColor.PURPLE);
        return rectangle;
    }
    @Override
    public boolean OverlapMyShapes
            () {
        return false;
    }
}