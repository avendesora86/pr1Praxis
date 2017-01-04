package pr1.a09;

import java.awt.*;

/**
 * Created by shari on 27.12.2016.
 */
public class Flower extends Plant {

    public Flower(int x, int y, int height){
        super(x, y, height, "Blume");
    }

    @Override
    public void changeTimeTo(double timeValue) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(100, 100, 10, 20);
        graphics.setColor(Color.GREEN);
        graphics.drawOval(100,100,20,20);
        graphics.setColor(Color.YELLOW);
    }
}
