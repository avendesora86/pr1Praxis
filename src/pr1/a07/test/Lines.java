package pr1.a07.test;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

import java.awt.*;


public class Lines implements Drawable{

    public void draw(Graphics l){
        l.setColor(Color.blue);
        l.drawLine(100, 100, 50, 100);

    }
}
