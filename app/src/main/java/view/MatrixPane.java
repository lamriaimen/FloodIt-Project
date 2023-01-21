package view;

import controller.GameController;
import javafx.animation.FillTransition;
import javafx.beans.NamedArg;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Cell;
import model.GrayGrid;
import model.ArrayGrid;
import model.Grid;

public class MatrixPane extends GridPane {
    public  final double tileWidth;
    public final double tileHeight;
    private final Integer numberOfColumns;
    private final Integer numberOfRows;
    private final Grid cellGrid;
    private GameController controller;

    public MatrixPane(@NamedArg("tileWidth") Double tileWidth,
                      @NamedArg("tileHeight") Double tileHeight,
                      @NamedArg("numberOfColumns") Integer numberOfColumns,
                      @NamedArg("numberOfRows") Integer numberOfRows) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;

        cellGrid= new ArrayGrid(numberOfRows,numberOfColumns);
    initMatrix();
    }


    public void setGameController(GameController controller){
        this.controller = controller;
    }

    private void initMatrix() {
        for (int rowIndex= 0; rowIndex < numberOfRows ; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                addCellRectangle(cellGrid.getCell(rowIndex,columnIndex),rowIndex,columnIndex);
            }
        }
    }

    public Grid getGrid(){
        return cellGrid;
    }

    private void addCellRectangle(Cell cell, int rowIndex, int columnIndex) {
        Rectangle rectangleCell = new Rectangle(tileWidth,tileHeight);
        rectangleCell.setStyle("-fx-stroke: black; -fx-stroke-width: 1");
        addStatePropertyListener(cell, rectangleCell);
        rectangleCell.setFill(cell.getColor());
        addClickEventHandler(cell, rectangleCell);
        add(rectangleCell, columnIndex, rowIndex);
    }

    private void addStatePropertyListener(Cell cell, Rectangle cellRectangle) {
        cell.getColorProperty().addListener((observable, oldValue, newValue) ->
                updateFill(cellRectangle, oldValue, newValue));
    }

    private void updateFill(Rectangle cellRectangle,Color cellColor, Color newCellColor) {
        new FillTransition(Duration.millis(35),cellRectangle,cellColor,newCellColor).play();
    }

    private void addClickEventHandler(Cell cell, Rectangle cellRectangle) {
        cellRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> controller.playHumanTurn(cell.getColor()));
    }

}
