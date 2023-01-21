package model;

import javafx.scene.paint.Color;

import java.util.Random;

public
class UniformExceptOneGenerator implements ColorGenerator {

    private Color  uniformColor;
    private Color  exceptionColor;
    private int    NbrCallUniform = 0;
    private int    NbrCallExcept  = 0;
    private Random rand;

    public
    UniformExceptOneGenerator ( Color uniformColor, Color exceptionColor ) {


        this.uniformColor   = uniformColor;
        this.exceptionColor = exceptionColor;


    }

    @Override
    public
    Color nextColor ( Cell cell ) {
        this.rand = new Random ( );
        boolean rand = this.rand.nextBoolean ( );
        if(NbrCallUniform==0){ NbrCallUniform++;return uniformColor;}
if ( rand &&this.NbrCallExcept==0 ){ NbrCallExcept++; return exceptionColor;}
      return uniformColor;


    }
}