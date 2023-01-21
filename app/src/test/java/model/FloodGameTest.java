package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static javafx.scene.paint.Color.*;
import static org.assertj.core.api.Assertions.assertThat;

class FloodGameTest {

    private final int totalNumberOfCells = 6;
    private final Grid gridTwoThree = new ArrayGrid(2,3);
    private final Color colorONE = RED;
    private final Color colorTWO = BLUE;
    private FloodGame game;
    private final Player playerONE = new ComputerPlayer("player1", gridTwoThree.getCell(0, 0), startCell -> colorONE);
    private final Player playerTWO = new ComputerPlayer("player2", gridTwoThree.getCell(1, 2), startCell -> colorTWO);

    @BeforeEach
    private void initGame(){
        game = new FloodGame(totalNumberOfCells);
    }


    @Test
    void testSetTurnAndGetTurn() {
        assertThat(game.getTurn()).isEqualTo(0);
        game.setTurn(100);
        assertThat(game.getTurn()).isEqualTo(100);
    }




    @Test
    void testResetTurn() {
        game.setTurn(100);
        game.resetTurn();
        assertThat(game.getTurn()).isEqualTo(0);
    }


    @Test
    void testIncrementTurn() {
        game.incrementTurn();
        game.incrementTurn();
        assertThat(game.getTurn()).isEqualTo(2);
    }

    @Test
    void testGetPlayer() {
        game.setPlayer(playerONE);
        game.setPlayer(playerTWO);
        assertThat(game.getPlayer()).isEqualTo(playerTWO);
        game.incrementTurn();
        assertThat(game.getPlayer()).isEqualTo(playerTWO);
    }

    @Test
    void testIsHumanTurn() {
        game.setPlayer(new HumanPlayer("human",gridTwoThree.getCell(1,2)));
        assertThat(game.isHumanTurn()).isTrue();
        game.setPlayer(playerONE);
        assertThat(game.isHumanTurn()).isFalse();
    }

    private void fillGridYellow(Grid grid){
        for(Cell cell: grid)
            cell.setColor(YELLOW);
    }

    @Test
    void testHasWon() {
        game.setPlayer(playerONE);
        gridTwoThree.getCell(0,0).setColor(RED);
        gridTwoThree.getCell(1,1).setColor(BLUE);
        assertThat(game.hasWon(game.getPlayer())).isFalse();
        fillGridYellow(gridTwoThree);
        assertThat(game.hasWon(game.getPlayer())).isTrue();
    }

    @Test
    void testHasEnded() {
        game.setPlayer(playerONE);
        gridTwoThree.getCell(1,2).setColor(RED);
        gridTwoThree.getCell(0,1).setColor(YELLOW);
        assertThat(game.hasEnded()).isFalse();
        fillGridYellow(gridTwoThree);
        assertThat(game.hasEnded()).isTrue();
    }

}