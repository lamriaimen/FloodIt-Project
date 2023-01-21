package model;

import javafx.beans.property.Property;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;

public class GrayCell extends AbstractCell{

    public static final Cell GRAY_CELL = new GrayCell();

    /**
     * A cell is placed somewhere on a grid. Its neighbours thus depend on the underlying grid.
     *
     * @return the list of cell that are neighbours of this{@code Cell}.
     */
    @Override
    public List<Cell> getNeighbours() {
        return null;
    }

    /**
     * Update the list of neighbours of this {@code Cell}.
     *
     * @param cells a list of cells that are the neighbours of this {@code cell}
     *              int the underlying grid.
     */
    @Override
    public void setNeighbours(List<Cell> cells) {

    }

    @Override
    public
    Iterator < Cell > iterator ( ) {
        return this.iterator();
    }

    @Override
    public void setColor(Color color){

    }
}
