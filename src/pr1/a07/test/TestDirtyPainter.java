package pr1.a07.test;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

/**
 * Created by shari on 06.12.2016.
 */
public class TestDirtyPainter {
    public static void main(String [] args){
        DirtyPainter p = new DirtyPainter();
//        p.add(new Gitter(100, 100));
        p.add(new Gitter(10, 10));
        p.add(new FirstGraphics());

        DirtyPainter d = new DirtyPainter();
        d.add(new Lines());

        d.showDrawing();
        p.showDrawing();

    }
}
