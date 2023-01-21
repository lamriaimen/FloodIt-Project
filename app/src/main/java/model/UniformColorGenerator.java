package model;

import javafx.scene.paint.Color;


public
class UniformColorGenerator implements ColorGenerator {
Color color;
    public UniformColorGenerator(Color color){
this.color=color;
    }

    @Override
    public
    Color nextColor ( Cell cell ) {
        return this.color ;
    }


}
