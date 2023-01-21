package model;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public
class DistinctColorGenerator implements ColorGenerator {


    private Color          defaultColor;
    private List < Color > colors;

    public
    DistinctColorGenerator ( List < Color > colors, Color defaultColor) {

this.colors=colors;
this.defaultColor=defaultColor;


    }




    @Override
    public
   Color nextColor ( Cell cell ) {


        List<Cell> neighbours = cell.getNeighbours();
        for( Color color : this.colors){
            boolean usedCell = false;
            for (Cell newCell:neighbours){
                if (color==newCell.getColor()){
                    usedCell=true;
                }
            }
            if (!usedCell){
                return color;
            }
        }
        return this.defaultColor;

    }
}