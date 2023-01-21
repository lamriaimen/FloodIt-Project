package model;

import javafx.scene.paint.Color;

public
class RandomStrategy implements PlayStrategy{
    private Cell startCell;
    public RandomStrategy(Cell startCell){

       this.startCell=startCell;


    }


    @Override
    public
    Color play ( Cell startCell ) {
        return null;
    }
}
