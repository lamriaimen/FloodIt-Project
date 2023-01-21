package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareCell extends AbstractCell{

   private List<Cell> neighbours;

    /**
     * A cell is placed somewhere on a grid. Its neighbours thus depend on the underlying grid.
     *
     * @return the list of cell that are neighbours of this{@code Cell}.
     */

    public SquareCell(){
        this.setColor(DEFAULT_CELL_COLOR);
        neighbours=new ArrayList<>();

    }

    public SquareCell(Color color) {

    this.setColor(color);
        neighbours=new ArrayList<>();



    }


    public SquareCell(Color color,List<Cell> cells) {
        this.setColor(color);
        neighbours=new ArrayList<>();
        neighbours=cells;



}





    @Override



    public List<Cell> getNeighbours() {
        return this.neighbours;
    }

    /**
     * Update the list of neighbours of this {@code Cell}.
     *
     * @param cells a list of cells that are the neighbours of this {@code cell}
     *              int the underlying grid.
     */
    @Override
    public void setNeighbours(List<Cell> cells) {
        this.neighbours=cells;

    }

    @Override
    public Iterator<Cell> iterator() {
        return null;
    }


}
