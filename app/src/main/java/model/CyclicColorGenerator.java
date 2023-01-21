package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public
class CyclicColorGenerator implements ColorGenerator {

    private List<Color> colors;
private int Index=0;

public CyclicColorGenerator( List < Color > colors){


this.colors=colors;
this.Index=0;


}



    @Override
    public
    Color nextColor ( Cell cell ) {

if(Index==colors.size ()-1) Index=-1;
 Index++;
        return this.colors.get( this.Index );





    }




}
