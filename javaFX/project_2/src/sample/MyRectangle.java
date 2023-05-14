package sample;
import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape{
    private double w, h;
    public MyRectangle(double x, double y,double w, double h, MyColor color){
        super(x,y,color);
        this.w = w;
        this.h = h;
    }
    public double getWidth() {
        return w;
    }
    public double getHeight() {
        return h;
    }
    public double getPerimeter() {
        return 2*(w+h);
    }
    public void setWidth(double x) { this.w = w; }
    public void setHeight(double y) { this.h = h; }

    public double getArea(){
        return w*h;
    }
    @Override
    public String toString() {
        return "The width of this rectangle is " + this.getWidth() + " and height is "
                + this.getHeight() + " so perimeter is "+this.getPerimeter() +"  and area is "+this.getArea();
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor().getMyColor());
        gc.setLineWidth(1);
        gc.fillRect(getX()-w/2, getY()-h/2, w, h);
    }
    @Override
    public MyRectangle getMyBoundingRectangle() {
        return this;
    }

    @Override
    public boolean OverlapMyShapes() {
        return false;
    }
}
