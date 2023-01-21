package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerTest {



//@Test
//    void testSetStrategyAndPlay() {
//        ComputerPlayer player = new ComputerPlayer("computer",null);
//        player.setStrategy(startCell -> Color.INDIGO);
//        player.setStartCell(new SquareCell());
//        assertThat(player.play()).isEqualTo(Color.INDIGO);
//    }


    @Test
    void testIsHuman() {
        assertThat(new ComputerPlayer("computer", null).isHuman()).isFalse();
    }
}