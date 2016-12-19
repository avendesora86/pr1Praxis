package pr1.a08;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;
import java.awt.Graphics;
import java.awt.Point;

public class RotatingPoint extends Point implements ChangingWithTime,Drawable {

    protected int r;
    protected long timeValue;


    public void changeTimeTo(double timeValue) {
        super.x += r * Math.cos(timeValue);
        super.y += r * Math.sin(timeValue);
    }

    public RotatingPoint(){
        this.r = 0;
        this.timeValue = 0;
    }

    public RotatingPoint(RotatingPoint rp) {
        this((int)rp.getX(),(int)rp.getY(), rp.getR(), rp.getTimeValue());
    }

    public RotatingPoint(int x, int y, int r, long timeValue) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.timeValue = timeValue;
        changeTimeTo(timeValue);
    }

    public int getR(){
        return this.r;
    }

    public long getTimeValue(){
        return this.timeValue;
    }

    /*
    returns true if all properties of rotatingpoint o are equal to the corresponding properties of this rotatingpoint
     */
    public boolean equals(RotatingPoint o) {
        if (getX() != o.getX()) return false;
        if (getY() != o.getY()) return false;
        if (getR() != o.getR()) return false;
        return getTimeValue() == o.getTimeValue();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getR();
        result = 31 * result + (int) (getTimeValue() ^ (getTimeValue() >>> 32));
        return result;
    }

    public String toString(){
    	return String.format("RotatingPoint: x: %1$d y:%2$d r: %3$d timeValue: %4$d", x, y, r, timeValue);
    }
//    @Override
//    public String toString() {
//        return "RotatingPoint{" +
//                "r=" + r +
//                ", timeValue=" + timeValue +
//                '}';
//	  }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawOval((int)getX() ,(int)getY(), 5, 5);
    }

    public void setTimeValue(long timeValue) {
        this.timeValue = timeValue;
    }
}
