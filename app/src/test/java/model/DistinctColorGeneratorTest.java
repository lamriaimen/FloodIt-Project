package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DistinctColorGeneratorTest {
    private final static Color initialColor = Color.GRAY;
    private final Grid grid = new ArrayGrid(2,3);
    @BeforeEach
    void initializeGridColor(){
        for (Cell cell: grid)
            cell.setColor(initialColor);
    }

    @Test
    void testNextColorWithTooFewAvailableColor() {

        DistinctColorGenerator colorGeneratorOne = new DistinctColorGenerator( List.of(Color.RED),Color.RED);
        grid.color(colorGeneratorOne);
        assertThat(grid.getCell(0,0).getColor()).isEqualTo(Color.RED);
        assertThat(grid.getCell(1,1).getColor()).isEqualTo(Color.RED);
        assertThat(grid.getCell(1,0).getColor()).isEqualTo(Color.RED);
    }

    @Test
    void testNextColorWithEnoughAvailableColor(){
        Color defaultColor = Color.BLACK;
        DistinctColorGenerator colorGenerator = new DistinctColorGenerator( List.of(Color.RED,Color.BLUE,Color.YELLOW, Color.ORANGE),defaultColor);
        grid.color(colorGenerator);
        for(Cell cell: grid){
            assertThat(cell.getNeighbours().stream().map(c-> c.getColor())).doesNotContain(cell.getColor());
            assertThat(cell.getColor()).isNotEqualTo(defaultColor).isNotEqualTo(initialColor);
        }
    }
}