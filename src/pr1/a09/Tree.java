package pr1.a09;

import java.awt.*;
import java.util.Random;

/**
 * Created by shari on 27.12.2016.
 */
public class Tree extends Plant {
    // properties of Tree (Kronendurchmesser; Blätteranzahl)
    protected int diameter;
    protected int leafNumber;
    protected int leafSize;

    //complete constructor
    public Tree(int x, int y, int height) {
        //calls the constructor of Plant (superclass) with given parameters
        super(x, y, height, "Baum");

        //initialising  properties with values from parameters
        adjustDiameter();
        this.leafSize = this.diameter / 5;
    }
    private void adjustDiameter(){
        this.diameter = this.height / 2;
    }


    @Override
    public void changeTimeTo(double timeValue) {
//    	height = (int) (3 * timeValue);
    	this.leafNumber = (int)timeValue;
//    	this.leafNumber = (int)(timeValue * Math.sin(timeValue));
//    	System.out.println(timeValue * (Math.sin(timeValue)));
        if (this.height < this.maxHeight){
            this.height += (int)(timeValue / 4);
            adjustDiameter();
        }

    }

    //method draws the Tree
    @Override
    public void draw(Graphics graphics) {

        int topX = this.x;
        int topY = this.y - this.height;
        //drawing the trunk; root at x,y ; trunk always 90 degrees; because the origin is top left corner therefore height has to be substracted of the treeroot.
        graphics.setColor(Color.gray);
        graphics.drawLine(this.x, this.y, this.x, topY);
        /* drawing the crown; trunktop and crowncenter should be identical.
        therefore the half of thw crwonwidth gets subtracted from
        the x-value and half of the crownheight gets subtracted  from the topY
         */
        graphics.setColor(Color.GREEN);
        graphics.drawOval((this.x - this.diameter / 2) , (topY - this.diameter / 2), this.diameter, this.diameter);

        /*
        leafnumber is the actual number of leafs that are drawn.
        for every leaf get a new leaforiginpoint
        draws the leaf at this point with given height and width
         */
        for(int i = 0; i < this.leafNumber; i++){
            Point leafOrigin = getNewLeafOrigin(topX, topY);
            graphics.drawRect(leafOrigin.x, leafOrigin.y, this.leafSize, this.leafSize);
        }
    }
    /*creates a new point which when used as origin for a new leaf makes
     sure that the center of the new leaf is somewhere within the crown
     */
    private Point getNewLeafOrigin(int topX, int topY){
        // creates a new object of type point which translates the position of the center of the leaf to the center of the top of the trunk
        Point p  = new Point(topX - this.leafSize / 2,topY - this.leafSize / 2);
        // create new rnd-object
        Random rnd = new Random();
        // creates a new int between 0 and diameter /2
        int dx = rnd.nextInt(this.diameter / 2);
        //creates a new int between 0 and diameter / 2
        int dy = rnd.nextInt(this.diameter / 2);

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
