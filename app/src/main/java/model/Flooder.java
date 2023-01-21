package model;

import javafx.scene.paint.Color;
import java.util.Iterator;

public class Flooder {

    public static void flood(Cell startCell, Color floodingColor){

        ColoredCellIterator CellIterator = new ColoredCellIterator(startCell);



        while (CellIterator.hasNext()){
            CellIterator.next().setColor(floodingColor);
        }
    }

    public static int coloredArea(Cell startCell){
        int colored=0;
        ColoredCellIterator CellIterator = new ColoredCellIterator(startCell);
        while (CellIterator.hasNext()){
            CellIterator.next();
            colored++;
        }
        return colored;
    }
}
