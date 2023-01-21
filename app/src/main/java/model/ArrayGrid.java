package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public
class ArrayGrid implements Grid {


    private int      numberOfRows;
    private int      numberOfColumns;
    private Cell[][] cells;


    public
    ArrayGrid ( int numberOfRows, int numberOfColumns ) {

        if ( numberOfColumns <= 0 || numberOfRows <= 0 ) {

            throw new IllegalArgumentException ( "" );

        }

        this.numberOfRows    = numberOfRows;
        this.numberOfColumns = numberOfColumns;


        this.cells = new Cell[ this.numberOfRows ][ this.numberOfColumns ];


        initGrid ( );

    }

    private
    void initGrid ( ) {


        for (int rowIndex = 0; rowIndex < this.numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.numberOfColumns; columnIndex++) {

                this.cells[ rowIndex ][ columnIndex ] = new SquareCell ( );


            }
        }


        for (int rowIndex = 0; rowIndex < this.numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.numberOfColumns; columnIndex++) {
                if ( rowIndex == 0 && columnIndex == 0 ) {

                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex ][ columnIndex + 1 ],
                                            this.cells[ rowIndex + 1 ][ columnIndex ] ) ) );
                }
                if ( rowIndex == this.numberOfRows - 1 && columnIndex == 0 ) {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex ][ columnIndex + 1 ],
                                            this.cells[ rowIndex - 1 ][ columnIndex ] ) ) );

                }
                if ( rowIndex == this.numberOfRows - 1 && columnIndex == this.numberOfColumns - 1 ) {

                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex - 1 ][ columnIndex ],
                                            this.cells[ rowIndex ][ columnIndex - 1 ] ) ) );
                }
                if ( rowIndex == 0 && columnIndex == this.numberOfColumns - 1 ) {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex ][ columnIndex - 1 ],
                                            this.cells[ rowIndex + 1 ][ columnIndex ] ) ) );
                }
                if ( rowIndex == 0 && columnIndex > 0 && columnIndex < this.numberOfColumns - 1 ) {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex + 1 ][ columnIndex ],
                                            this.cells[ rowIndex ][ columnIndex - 1 ],
                                            this.cells[ rowIndex ][ columnIndex + 1 ] ) ) );
                }
                if ( rowIndex == this.numberOfRows - 1 && columnIndex > 0 && columnIndex < this.numberOfColumns - 1 ) {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex - 1 ][ columnIndex ],
                                            this.cells[ rowIndex ][ columnIndex - 1 ],
                                            this.cells[ rowIndex ][ columnIndex + 1 ] ) ) );
                }
                if ( columnIndex == 0 && rowIndex > 0 && rowIndex < this.numberOfRows - 1 ) {

                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex ][ columnIndex + 1 ],
                                            this.cells[ rowIndex + 1 ][ columnIndex ],
                                            this.cells[ rowIndex - 1 ][ columnIndex ] ) ) );
                }

                if ( columnIndex == this.numberOfColumns - 1 && rowIndex > 0 && rowIndex < this.numberOfRows - 1 ) {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex - 1 ][ columnIndex ],
                                            this.cells[ rowIndex ][ columnIndex - 1 ],
                                            this.cells[ rowIndex - 1 ][ columnIndex ] ) ) );
                }
                if ( rowIndex > 0 && rowIndex < this.numberOfRows - 1 && columnIndex > 0
                        && columnIndex < this.numberOfColumns - 1 )
                {
                    this.cells[ rowIndex ][ columnIndex ].setNeighbours ( new ArrayList <> (
                            Arrays.asList ( this.cells[ rowIndex - 1 ][ columnIndex ],
                                            this.cells[ rowIndex + 1 ][ columnIndex ],
                                            this.cells[ rowIndex ][ columnIndex - 1 ],
                                            this.cells[ rowIndex ][ columnIndex + 1 ] ) ) );

                }

            }
        }

    }

    public
    Cell getCell ( int row, int column ) {
        return cells[ row ][ column ];
    }


    public
    int getNumberOfRows ( ) {
        return this.numberOfRows;
    }

    public
    int getNumberOfColumns ( ) {
        return this.numberOfColumns;
    }

    public
    void color ( ColorGenerator colorGenerator ) {


        for (Cell[] row : this.cells) {
            for (Cell cell : row) {


                cell.setColor ( colorGenerator.nextColor ( cell ) );


            }


        }
    }

    public
    Iterator < Cell > iterator ( ) {
        return new CellGridIterator ( this );


    }


}
