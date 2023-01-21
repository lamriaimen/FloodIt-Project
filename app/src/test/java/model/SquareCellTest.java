package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SquareCellTest {


    private final Cell northCell = new SquareCell(Color.NAVY);
    private final Cell southCell = new SquareCell(Color.SALMON);
    private final Cell westCell = new SquareCell(Color.WHEAT);
    private final Cell eastCell = new SquareCell(Color.DARKGRAY);
    private final Cell centralCell = new SquareCell(Color.CHOCOLATE);


    @BeforeEach
    void testInitializeNeighbourhood(){
        centralCell.setNeighbours(List.of(northCell,southCell,westCell,eastCell));
        westCell.setNeighbours(List.of(centralCell));
        eastCell.setNeighbours(List.of(centralCell));
        southCell.setNeighbours(List.of(centralCell));
        northCell.setNeighbours(List.of(centralCell));
    }
    @Test
    void testIterator() {
    }

    @Test
    void testGetNeighbours() {
        assertThat(centralCell.getNeighbours()).hasSize(4).containsExactlyInAnyOrder(northCell,southCell,eastCell,westCell);
        assertThat(eastCell.getNeighbours()).hasSize(1).contains(centralCell);
        assertThat(new SquareCell().getNeighbours()).hasSize(0).isEmpty();
        assertThat(new SquareCell(Color.BLACK).getNeighbours()).hasSize(0).isEmpty();
        assertThat(new SquareCell(Color.BLACK, new ArrayList<>()).getNeighbours()).isEmpty();
    }

    @Test
    void testSetNeighbours() {
        Cell cell = new SquareCell(Color.GREEN);
        cell.setNeighbours(List.of(centralCell));
        assertThat(cell.getNeighbours()).containsExactlyInAnyOrder(centralCell);
        centralCell.setNeighbours(List.of(northCell,southCell));
        assertThat(centralCell.getNeighbours()).containsExactlyInAnyOrder(northCell,southCell);
    }
}