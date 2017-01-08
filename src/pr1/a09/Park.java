package pr1.a09;

import pr1.a08.*;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by shari on 08.01.2017.
 */
public class Park implements Drawable, pr1.a08.ChangingWithTime{

    protected ArrayList<Plant> plants;

    public Park(){

        this.plants = new ArrayList<Plant>();
    }

    @Override
    public void changeTimeTo(double timeValue) {
        for (Plant p : this.plants){
            p.changeTimeTo(timeValue);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Plant p : this.plants){
            p.draw(graphics);
        }
    }

    public boolean add (Plant p){

        return this.plants.add(p);
    }
}
