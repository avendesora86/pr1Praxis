package pr1.a07.test;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

import java.awt.*;

/**
 * Created by shari on 07.12.2016.
 */
public class Gitter implements Drawable {

    private static final int width = 1000;
    private static final int height = 1000;
    protected int dx;
    protected int dy;
    protected Color gridColor;
//    protected int arrowWidth = 6;
//    protected int arrowLength = 8;

    public Gitter(){
        this.dx = 100;
        this.dy = 100;
        this.gridColor = Color.yellow;
    }

    public Gitter(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
        this.gridColor = Color.yellow;
    }

    public Gitter(int dx, int dy, Color gridColor){
        this.dx = dx;
        this.dy = dy;
        this.gridColor = gridColor;
    }

    public void draw(Graphics graphics) {
        drawHorizontalGridLines(graphics);
        drawVerticalGridLines(graphics);
        drawAxis(graphics);
    }

    // Draw horizontal GridLines
    private void drawHorizontalGridLines(Graphics g){
        // Set Color to GridColor
        g.setColor(this.gridColor);
        /* Get Y-Values for first upper and lower GridLines
           Add/Sub dy to prevent drawing the axis twice
           Start painting GridLines from the middle
        */
        int upper = (height / 2) - dy;
        int lower = (height / 2) + dy;
        // Paint upper GridLines
        while(upper >= 0){
            g.drawLine(0, upper, width, upper);
            upper -= dy;
        }
        // Paint lower GridLines
        while(lower <= height){
            g.drawLine(0, lower, width, lower);
            lower += dy;
        }
    }

    // Draw vertical GridLines
    private void drawVerticalGridLines(Graphics g){
        // Set Color to GridColor
        g.setColor(this.gridColor);
        /* Get Y-Values for first upper and lower GridLines
           Add/Sub dy to prevent drawing the axis twice
           Start painting GridLines from the middle
        */
        int left = (width / 2) - dx;
        int right = (width / 2) + dx;
        // Paint left GridLines
        while(left >= 0){
            g.drawLine(left, 0, left, height);
            left -= dx;
        }
        // Paint right GridLines
        while(right <= width){
            g.drawLine(right, 0, right, height);
            right += dx;
        }
    }

    private void drawAxis(Graphics g){
        /* Convert to Graphics2D object to set StrokeWidth
           of Axis.
           This is OPTIONAL
         */
        Graphics2D g2 = (Graphics2D)g;
        // Set StrokeWidth to 2
        g2.setStroke(new BasicStroke(1));
        // Set color to blue
        g2.setColor(Color.blue);
        // Paint X-Axis
        g2.drawLine(0, width / 2, height, width / 2);
        // Paint Y-Axis
        g2.drawLine(height / 2, 0, height / 2, width);

//        /*
//           Draw Triangles at the end of each axis (Arrows)
//           This is OPTIONAL
//         */
//
//        // Create Point arrays for xArrowHead
//        int[] xa = {width,(width - arrowLength),(width - arrowLength),width};
//        int[] xb = {height / 2,(height / 2) - (arrowWidth / 2),(height / 2) + (arrowWidth / 2),height / 2};
//        // Create Point arrays for yArrowHead
//        int[] ya = {width / 2, (width / 2) - (arrowWidth / 2),(width / 2) + (arrowWidth / 2), width / 2};
//        int[] yb= {0, arrowLength, arrowLength,0};
//        // Create polygons from Point arrays
//        Polygon xArrow = new Polygon(xa, xb, 4);
//        Polygon yArrow = new Polygon(ya, yb, 4);
//        // Fill Polygons
//        g2.fill(xArrow);
//        g2.fill(yArrow);
//        // Draw Polygons
//        g.drawPolygon(xArrow);
//        g.drawPolygon(yArrow);
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public void setGridColor(Color color) {
        this.gridColor = color;
    }
}