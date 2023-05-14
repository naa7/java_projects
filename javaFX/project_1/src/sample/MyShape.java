package sample;

import javafx.scene.canvas.GraphicsContext;
import java.awt.*;

public class MyShape {
    private double x, y;
    private Color color;
    public MyShape(final double x, final double y, final Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public javafx.scene.paint.Color getColor() {
        final java.awt.Color awtColor = this.color;
        final int r = awtColor.getRed();
        final int g = awtColor.getGreen();
        final int b = awtColor.getBlue();
        final int a = awtColor.getAlpha();
        final double opacity = a / 255.0 ;
        final javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
        return fxColor;
    }
    public void setX(final double x) {
        this.x = x;
    }
    public void setY(final double y) {
        this.y = y;
    }
    public void setColor(final Color color) {
        this.color = color;
    }
    public void shiftXY(final double x, final double y) {
        this.x += x;
        this.y += y;
    }
    public String toString() {
        return "The coordinate of X and Y is (" + getX() + "," + getY() + ") and the color is " + getColor();
    }
    public void draw(final GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(0, 0, this.x, this.y);
    }
}