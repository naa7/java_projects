package sample;

public interface MyPoint {
    public void setXCoordinates(double x);
    public  void setYCoordinates(double y);
    public double [] getXYCoordinates();
    public void moveTo(double x,double y);
    public double distanceTo(double x,double y);
}
