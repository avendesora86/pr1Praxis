package pr1.a08;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class Main {

    public static void main(String [] args){

        double  timeValue = 0;
        DirtyPainter paint = new DirtyPainter();
        RotatingPoint rp;
        while (true){
            rp = new RotatingPoint(100, 100, 50, (long)timeValue);
            paint.add(rp);
            paint.showDrawingAfterWaiting(30);
            timeValue += 30;
            paint.remove(rp);
        }
    }
}
