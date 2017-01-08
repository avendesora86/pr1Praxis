package pr1.a09;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

/**
 * Created by shari on 27.12.2016.
 */
public class Main {

    public static void main (String[] args){
        Park park = new Park();

        park.add(new Flower (300, 300, 30));
        park.add(new Flower (800, 800, 40));
        park.add(new Tree (400, 500, 80));
        park.add(new Tree (550, 800, 90));
        park.add(new Bush (700, 450, 50));
        park.add(new Bush (200, 600, 60));
        growPark(park);
    }

    public static void growPark(Park p){
        DirtyPainter paint = new DirtyPainter();
        paint.add(p);
        while (true){
            for( int i = 0; i<= 24; i++){
                paintPark(p, i, paint);
            }
            for (int i = 23; i>= 1; i --){
                paintPark(p, i, paint);
            }
        }
    }

    public static void paintPark(Park p, int i, DirtyPainter paint){
        paint.remove(p);
        p.changeTimeTo(i);
        paint.add(p);
        paint.showDrawingAfterWaiting(500);
    }
}
