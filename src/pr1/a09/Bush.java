package pr1.a09;

import java.awt.*;
import java.util.Random;

/**
 * Created by shari on 27.12.2016.
 */
public class Bush extends Plant {

    protected int fruitNumber;
    protected int width;

    public Bush(int x, int y, int height){
        super(x, y, height, "Strauch");

    }
    private void adjustWidth(){
        this.width = this.height*2;

    }

    @Override
    public void changeTimeTo(double timeValue) {
        this.fruitNumber = (int)timeValue;
        if (this.height < this.maxHeight){
            this.height += (int) (timeValue / 4);
            adjustWidth();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        int fruitSize =  this.height / 5;
        graphics.setColor(Color.orange);
        graphics.drawOval(this.x - this.width / 2, this.y - this.height / 2, this.width, this.height);
        graphics.fillOval(this.x - this.width / 2, this.y - this.height / 2, this.width, this.height);
        graphics.setColor(Color.red);

        for(int i = 0; i < this.fruitNumber; i++) {
            Point fruitOrigin = getNewFruitOrigin(this.x, this.y, fruitSize);
            graphics.drawOval(fruitOrigin.x, fruitOrigin.y, fruitSize, fruitSize);
        }
    }

    /*creates a new point which when used as origin for a new fruit makes
 sure that the center of the new fruit is somewhere within the crown
 */
    private Point getNewFruitOrigin(int centerX, int centerY, int fruitSize){
        // creates a new object of type point which translates the position of the center of the fruit to the center of the bush
        Point p  = new Point(centerX - fruitSize / 2,centerY - fruitSize / 2);
        // create new rnd-object
        Random rnd = new Random();
        // creates a new int between 0 and width /2
        int dx = rnd.nextInt(this.width / 2);
        //creates a new int between 0 and height / 2
        int dy = rnd.nextInt(this.height / 2);

        //if bool true then dx will be negative
        if (rnd.nextBoolean()){
            dx *= -1;
        }
        // if bool true then dy will be negative
        if (rnd.nextBoolean()){
            dy *= -1;
        }
//        // translate x/y values of p by dx and dy
        p.x += dx;
        p.y += dy;

        return p;
    }
}
