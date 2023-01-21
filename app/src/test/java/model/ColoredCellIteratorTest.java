package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ColoredCellIteratorTest {


    /*
     * +---+---+---+
     * | R | B | R |
     * +---+---+---|
     * | R | R | B |
     * |---+---+---+
     * | B | B | R |
     * +---+---+---+
     */

    private static ArrayGrid gridThreeThree = new ArrayGrid(3,3);

    @BeforeAll
    private static void initializeColorsGrid(){
        gridThreeThree.getCell(0,0).setColor(Color.RED);
        gridThreeThree.getCell(0,1).setColor(Color.BLACK);
        gridThreeThree.getCell(0,2).setColor(Color.RED);
        gridThreeThree.getCell(1,0).setColor(Color.RED);
        gridThreeThree.getCell(1,1).setColor(Color.RED);
        gridThreeThree.getCell(1,2).setColor(Color.BLACK);
        gridThreeThree.getCell(2,0).setColor(Color.BLACK);
        gridThreeThree.getCell(2,1).setColor(Color.BLACK);
        gridThreeThree.getCell(2,2).setColor(Color.RED);
    }

    @Test
    void testIterator() {
        ColoredCellIterator redCellIterator = new ColoredCellIterator(gridThreeThree.getCell(0,0));
        List<Cell> expectedRedCells = List.of(gridThreeThree.getCell(0,0),
                gridThreeThree.getCell(1,0),
                gridThreeThree.getCell(1,1));
        List<Cell> fromIteratorCells = new ArrayList<>();
        for(;redCellIterator.hasNext();) fromIteratorCells.add(redCellIterator.next());
        assertThat(fromIteratorCells).hasSameElementsAs(expectedRedCells).hasSameSizeAs(expectedRedCells);

        ColoredCellIterator blackCellIterator = new ColoredCellIterator(gridThreeThree.getCell(2,1));
        List<Cell> expectedBlackCells = List.of(gridThreeThree.getCell(2,0),
                gridThreeThree.getCell(2,1));
        fromIteratorCells = new ArrayList<>();
        for( ; blackCellIterator.hasNext(); ) fromIteratorCells.add(blackCellIterator.next());
        assertThat(fromIteratorCells).hasSameElementsAs(expectedBlackCells).hasSameSizeAs(expectedBlackCells);

    }

}