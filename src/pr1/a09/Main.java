package pr1.a09;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

/**
 * Created by shari on 27.12.2016.
 */
public class Main {

    public static void main (String[] args){

        Tree baum = new Tree(100, 100, 50);//, 50, 50, 5, 5, 20);

        DirtyPainter tree =  new DirtyPainter();
        tree.add(baum);
        
        
        tree.showDrawing();
    }
}
