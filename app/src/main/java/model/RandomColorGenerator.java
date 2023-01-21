package model;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public
class RandomColorGenerator implements ColorGenerator{
private Random random;
private List<Color> colors;

    public RandomColorGenerator( List < Color > colors,
                                 Random randomGenerator){

this.colors=colors;
this.random=randomGenerator;



    }

    @Override
    public
    Color nextColor ( Cell cell ) {

        int Index= this.random.nextInt(this.colors.size());

        Color RandColor= this.colors.get( Index );
return RandColor;

    }
}
