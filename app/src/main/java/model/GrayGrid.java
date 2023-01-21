package model;

import java.util.Iterator;

public class GrayGrid implements Grid {

    private final int numberOfRows;
    private final int numnberOfColumns;

    public
    GrayGrid ( int numberOfRows , int numberOfColumns ) {
        this.numberOfRows     = numberOfRows;
        this.numnberOfColumns = numberOfColumns;
    }

    /**
     * Return the cell located at the given coordinates in the grid.
     *
     * @param row    the row of the returned the cell
     * @param column the column of the returned cell
     * @return the cell located in row {@code row} and in column {@code column}
     */
    @Override
    public
    Cell getCell ( int row , int column ) {
        return GrayCell.GRAY_CELL;
    }

    /**
     * Return the number of rows of this {@code Grid}
     *
     * @return the number of rows of this {@code Grid}
     */
    @Override
    public
    int getNumberOfRows ( ) {
        return numberOfRows;
    }

    /**
     * Return the number of columns of this {@code Grid}
     *
     * @return the number of columns of this {@code Grid}
     */
    @Override
    public
    int getNumberOfColumns ( ) {
        return numnberOfColumns;
    }

    @Override
    public
    void color ( ColorGenerator colorGenerator ) {

    }

    @Override
    public
    Iterator<Cell> iterator ( ) {
        Iterator IT= javafx.scene.control.Cell.getClassCssMetaData ( ).iterator ( );
        return IT;
    }
}