package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape{
    private double w, h;
    public MyOval(double x, double y, double w, double h, MyColor color){
        super(x,y,color);
        this.w = w;
        this.h = h;
    }

    public MyOval(double x, double y, MyColor color) {
        super(x,y,color);
    }

    public double getWidth() {
        return w;
    }
    public double getHeight() {
        return h;
    }
    public double getPerimeter() {
        return 0.5*Math.PI*(w+h);
    }
    public double getCenter() { return (w+h)/2; }

    public double getArea(){
        return 0.25*Math.PI*w*h;
    }
    @Override
    public String toString() {
        return "The width of this ellipse is " + this.getWidth() + " and height is "
                + this.getHeight() + " so perimeter is "+this.getPerimeter() +"  and area is "+this.getArea();
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor().getMyColor());
        gc.setLineWidth(1);
        gc.fillOval(getX()-w/2, getY()-h/2, w, h);
    }
    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rectangle = new MyRectangle(super.getX(),super.getY(),w,h,MyColor.PURPLE);
        return rectangle;
    }

    @Override
    public boolean OverlapMyShapes() {
        return false;
    }
}
