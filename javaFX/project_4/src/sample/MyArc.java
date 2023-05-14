package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MyArc extends MyShape {

    public MyArc(int w, int h, int x, int y, MyColor color) {
        super(x,y,color);
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        n = 0;
    }
    public int n, w, h, x, y;  // N, width, height, center x, center y
    ArrayList<Float> probes = new ArrayList<Float>();
    ArrayList<String> keys = new ArrayList<String>();
    // colors for different event on chart
    List<MyColor> colors = Arrays.asList(MyColor.OLIVE, MyColor.PURPLE, MyColor.TEAL, MyColor.WISTERIA, MyColor.MAROON,
            MyColor.BLUE, MyColor.GRAY, MyColor.PURPLE, MyColor.OLIVE);

    @Override
    public String toString(double i, double j, double radius)
    {
        return "The coordinate of X and Y is (" + getX(i) + "," + getY(i) + ") and the radius is (" + radius + ")";
    }

      // Draw chart

    @Override
    public void draw(GraphicsContext gc) {
        double currentAngle = 0;
        int colorCount = 0;
        for(int i = 0; i <= n; i++) {
            // calculate arc base on probability value. 1.0 mean 360 degrees
            double arcExtent = probes.get(i) * 360;
            if (i == n) {
                // last arc calculation
                arcExtent = 360 - currentAngle;
            }
            // set color the current arc
            setColor(gc,colorCount);
            // draw arc
            gc.strokeArc(x - w / 2, y - h / 2, w, h, currentAngle, arcExtent, ArcType.ROUND);
            gc.fillArc(x - w / 2, y - h / 2, w, h, currentAngle, arcExtent, ArcType.ROUND);
            // calculate position for label
            double radius = sqrt(w * w + h * h);
            double tx = x + radius * cos(Math.toRadians(currentAngle+arcExtent / 2)) / 2 - 50;
            double ty = y - radius * sin(Math.toRadians(currentAngle+arcExtent / 2)) / 2;
            toString(tx,ty,radius);
            // draw label
            if (i == n) {
                // draw last (remaining)
                gc.fillText("F, " + Math.round(25*probes.get(i)) + " Students", tx, ty);
                //System.out.println(keys.get(i) + ", " + probes.get(i));
                //System.out.println(keys.get(i+1) + ", " + probes.get(i+1));
            } else {
                // draw character with probability
                gc.fillText(keys.get(i) + ", " + Math.round(25*probes.get(i)) + " Students", tx, ty);
                //System.out.println(keys.get(i) + ", " + probes.get(i));
            }
            // update current angle for next arc calculation
            currentAngle = currentAngle + arcExtent;
            // next color in colors array
            colorCount++;
        }
    }

      // Set color of each event on chart

    public void setColor(GraphicsContext gc, int i)
    {
        gc.setFill(super.getColor(colors.get(i % colors.size())).getMyColor());
    }

}
