package model;

import javafx.scene.paint.Color;
import util.SetUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ColoredCellIterator implements Iterator<Cell> {

    private Color color;
    private Cell startCell;
    private Set<Cell> pendingCells;
    private Set<Cell> visitedCells;
    public ColoredCellIterator(Cell startCell ){
        this.pendingCells = new HashSet<>();
        this.visitedCells = new HashSet<>();
        this.startCell=startCell;
        this.color=startCell.getColor();
        pendingCells.add(startCell);
    }



    @Override
    public boolean hasNext() {
        return !(pendingCells.isEmpty());
    }

    @Override
    public Cell next() {
        startCell = SetUtil.anyElement(pendingCells);
        for (Cell c : startCell.getNeighbours()) {
            if (c.getColor().equals(startCell.getColor()) && !visitedCells.contains(c)) {
                pendingCells.add(c);
            }
        }
        Cell cell=startCell;
        pendingCells.remove(startCell);
        visitedCells.add(startCell);
        return cell;
    }
}