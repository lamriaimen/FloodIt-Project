package model;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComputerPlayer implements Player {
    private String name;
    private Cell   startCell;

   public ComputerPlayer ( String name, Cell startCell ) {
        this.name      = name;
        this.startCell = startCell;

    }

   public ComputerPlayer ( String name, Cell startCell, PlayStrategy strategy ) {
        this.name      = name;
        this.startCell = startCell;

        strategy.play ( startCell );

    }


    public
    void setColor ( Color color ) {
        startCell.setColor ( color );
    }


    @Override
    public
    boolean isHuman ( ) {
        return false;
    }

    @Override
    public
    void setName ( String name ) {
        this.name = name;

    }

    @Override
    public
    String getName ( ) {
        return name;
    }

    @Override
    public
    Cell getStartCell ( ) {
        return startCell;
    }

    public
    Color play ( ) {
        return startCell.getColor ( );
    }

}