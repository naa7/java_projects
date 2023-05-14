package sample;
import javafx.scene.canvas.GraphicsContext;

abstract class MyShape implements MyShapeInterface {
    private double x, y;
    private MyColor color;
    public MyShape(double x, double y, MyColor color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY() { return this.y; }
    public MyColor getColor() {return color; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setColor(MyColor color) { this.color = color; }

    public String toString()
    {
        return "The coordinate of X and Y is (" + getX() + "," + getY() + ") and the color is " + getColor();
    }
    public void draw(GraphicsContext gc) {};
}