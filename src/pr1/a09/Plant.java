package pr1.a09;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

/**
 * Created by shari on 27.12.2016.
 */
public abstract class Plant implements Drawable, ChangingWithTime {

    protected int x;
    protected int y;
    protected String name;
    protected int height;

    public Plant(int x, int y, int height, String name){
        this.x =  x;
        this.y =  y;
        this.height = height;
        this.name = name;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return String.format("x: %1$d y: %2$d name: %4$d", x, y, name);
    }
}

