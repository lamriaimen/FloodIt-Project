package model;

import javafx.beans.property.Property;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;


public interface Cell {

    /**
     * Change the color of this {@code Cell} to {@code color}.
     * @param color the color this {@code Cell} is changed to.
     */
    void  setColor(Color color);

    /**
     * Return the color of this {@code Cell}.
     * @return the current color of this {@code cell}.
     */
    Color getColor();

    /**
     * A cell is placed somewhere on a grid. Its neighbours thus depend on the underlying grid.
     *
     * @return the list of cell that are neighbours of this{@code Cell}.
     */
    List<Cell> getNeighbours();

    /**
     * Update the list of neighbours of this {@code Cell}.
     * @param cells a list of cells that are the neighbours of this {@code cell}
     *              int the underlying grid.
     */
    void setNeighbours(List<Cell> cells);

    /**
     * Returns this {@link Cell}'s property.
     *
     * @return this {@link Cell}'s property
     */
    Property<Color> getColorProperty();

    Iterator<Cell> iterator();
}
