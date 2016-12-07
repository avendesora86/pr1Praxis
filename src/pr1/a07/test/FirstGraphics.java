package pr1.a07.test;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

import java.awt.*;

/**
 * Created by shari on 06.12.2016.
 */
public class FirstGraphics implements Drawable{

        public void draw(Graphics g){
            g.setColor(Color.BLACK);
            g.drawRect(111, 111, 333, 444);
            g.setColor(Color.BLACK);
            g.drawOval(55, 50, 200, 100);



        }
}
