package model;

import javafx.scene.paint.Color;

import java.util.Iterator;

public class HumanPlayer implements Player{
    String name;
    Cell startCell;


    public HumanPlayer(String name, Cell startCell){
        this.name=name;
        this.startCell=startCell;
    }


    public HumanPlayer(Cell startCell){
        this.startCell=startCell;
    }



    @Override
    public void setName(String name) {
this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Cell getStartCell() {
        return this.startCell;
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    Iterator <Cell> iterator ( ){
        return new ColoredCellIterator (this.startCell);



    }

}
