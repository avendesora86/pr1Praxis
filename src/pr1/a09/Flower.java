package pr1.a09;

import java.awt.*;

/**
 * Created by shari on 27.12.2016.
 */
public class Flower extends Plant {

    protected int diameter;

    public Flower(int x, int y, int height){
        super(x, y, height, "Blume");
        this.maxHeight = this.height / 3;
    }

    @Override
    public void changeTimeTo(double timeValue) {
        this.diameter = (int) (timeValue * (this.height / 18));
    }

    @Override
    public void draw(Graphics graphics) {

        int topY = this.y - this.height;
        graphics.setColor(Color.GREEN);
        graphics.drawLine(this.x, this.y, this.x, topY);
        graphics.setColor(Color.YELLOW);
        graphics.drawOval((this.x - this.diameter / 2) , (topY - this.diameter / 2), this.diameter, this.diameter);
        graphics.fillOval((this.x - this.diameter / 2) , (topY - this.diameter / 2), this.diameter, this.diameter);
    }
}
