package model;

public interface  Grid extends Iterable<Cell>  {

    /**
     * Return the cell located at the given coordinates in the grid.
     * @param row the row of the returned the cell
     * @param column the column of the returned cell
     * @return the cell located in row {@code row} and in column {@code column}
     */
    Cell getCell(int row, int column);

    /**
     * Return the number of rows of this {@code Grid}
     * @return the number of rows of this {@code Grid}
     */
    int getNumberOfRows();

    /**
     * Return the number of columns of this {@code Grid}
     * @return the number of columns of this {@code Grid}
     */
    int getNumberOfColumns();

    /**
     * Color every cell of this {@code Grid} using the provided {@code ColorGenerator}
     * @param colorGenerator the generator used to determine the color of each cell.
     *                       The new color of {@code cell} is obtained by calling the method {@code nextColor}
     */
    void color(ColorGenerator colorGenerator);



}
