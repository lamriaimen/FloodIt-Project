package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArrayGridTest {


    private ArrayGrid arrayGridThreeFour;
    private final ArrayGrid arrayGridTwoTwo = new ArrayGrid(2, 2);

    @BeforeEach
    void initializeArrayGridThreeFour() {
        arrayGridThreeFour = new ArrayGrid(3, 4);
    }


    @Test
    void testGetCellAndGridInitialization() {
        assertThat(arrayGridThreeFour.getCell(0, 0).getNeighbours())
                .hasSize(2)
                .containsExactlyInAnyOrder(arrayGridThreeFour.getCell(1, 0), arrayGridThreeFour.getCell(0, 1));
        assertThat(arrayGridThreeFour.getCell(1, 1).getNeighbours()).hasSize(4)
                .containsExactlyInAnyOrder(arrayGridThreeFour.getCell(0, 1),
                        arrayGridThreeFour.getCell(2, 1),
                       arrayGridThreeFour.getCell(1, 2), arrayGridThreeFour.getCell(1, 0));
        assertThat(arrayGridThreeFour.getCell(2, 3).getNeighbours()).hasSize(2)
                .containsExactlyInAnyOrder(arrayGridThreeFour.getCell(1, 3),
                        arrayGridThreeFour.getCell(2, 2));
        assertThat(arrayGridThreeFour.getCell(2, 2).getNeighbours()).hasSize(3)
               .containsExactlyInAnyOrder(arrayGridThreeFour.getCell(1, 2),
                       arrayGridThreeFour.getCell(2, 1),
                     arrayGridThreeFour.getCell(2, 3));
    }

    @Test
    void testConstructionWithIllegalParameters() {
        assertThatThrownBy(() -> new ArrayGrid(-4, 10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ArrayGrid(4, 0)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void testGetNumberOfRows() {
        assertThat(new ArrayGrid(100, 200).getNumberOfRows()).isEqualTo(100);
    }

    @Test
    void testGetNumberOfColumns() {
        assertThat(new ArrayGrid(100, 200).getNumberOfColumns()).isEqualTo(200);
    }

    private void setArrayGridThreeFourRed() {
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                arrayGridThreeFour.getCell(rowIndex, columnIndex).setColor(Color.RED);
            }
        }
    }

    @Test
    void testColor() {
        setArrayGridThreeFourRed();
        arrayGridThreeFour.color(cell -> Color.BLACK);
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                assertThat(arrayGridThreeFour.getCell(rowIndex, columnIndex).getColor()).isEqualTo(Color.BLACK);
            }
        }
    }

    @Test
    void testIterator() {
        Iterator<Cell> iterator = arrayGridTwoTwo.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(arrayGridTwoTwo.getCell(0,0));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(arrayGridTwoTwo.getCell(0,1));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(arrayGridTwoTwo.getCell(1,0));
        assertThat (  iterator.next()).isEqualTo ( arrayGridTwoTwo.getCell ( 1,1 ) );
       assertThat(iterator.hasNext()).isFalse();

    }

}