package sample;

import javafx.scene.canvas.GraphicsContext;

abstract class MyShape {
    private double x, y;
    public MyColor color;

    public MyShape(int x, int y, MyColor color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public double getX(double i)
    {
        return x = i;
    }
    public double getY(double j) { return y = j; }
    public MyColor getColor(MyColor color) {return color; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setColor(MyColor color) { this.color = color; }

    public String toString(double i, double j, double radius)
    {
        return "The coordinate of X and Y is (" + getX(i) + "," + getY(i) + ") and the radius is (" + radius + ")";
    }
    public void draw(GraphicsContext gc) {};
}