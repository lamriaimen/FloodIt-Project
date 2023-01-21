package model;

import java.util.Iterator;

public
class CellGridIterator implements Iterator<Cell> {

    private ArrayGrid grid;
    private int PrvColmnNum;
    private int PrvRowNum;
    private int ActColmnNum;
    private int ActRowNum;


    CellGridIterator(ArrayGrid grid){

        PrvRowNum=ActRowNum=0;
        PrvColmnNum=ActColmnNum=0;
        this.grid=grid;



    }






    public
    boolean hasNext ( ) {
        return hasNextRow ()|| hasNextCol ();
    }

    public
    Boolean hasNextCol (){


        return !(grid.getNumberOfColumns ()==ActColmnNum);

    }

    public Boolean hasNextRow(){


        return !(grid.getNumberOfRows ()-1==this.ActRowNum);

    }


  public   Cell next ( ) {

    if ( hasNextCol ( ) ) {
        PrvColmnNum=ActColmnNum;
        ActColmnNum++;
        return grid.getCell (PrvRowNum,PrvColmnNum );


    }
    if ( hasNextRow ( ) ) {
        ActRowNum++;

        ActColmnNum=1;
        PrvColmnNum=0;


        PrvRowNum=ActRowNum;

        return grid.getCell ( PrvRowNum , PrvColmnNum );


    }
     return null;

    }


}
