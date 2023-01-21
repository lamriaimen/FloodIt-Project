package model;

import java.util.ArrayList;
import java.util.Random;

public
class RandomUtil {

    private
    RandomUtil ( ) {
    }

    ;


    public static
    < T > T randomElement ( T[] elements, Random random ) {

        random = new Random ( );

        int k = random.nextInt ( elements.length ) + 0;
        return elements[ k ];


    }

    public static
    < T > T randomElement ( ArrayList < T > elements, Random random ) {


        random = new Random ( );

        int k = random.nextInt ( elements.size ( ) ) + 0;
        return elements.get ( k );


    }


}
