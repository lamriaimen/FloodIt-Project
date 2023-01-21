package model;

import javafx.scene.paint.Color;

import java.util.List;

public class RobinStrategy implements PlayStrategy {
    private final List<Color> availableColors;
    private int index = 0;
    public RobinStrategy(List<Color> availableColors) {
        this.availableColors = availableColors;
    }




    @Override
    public Color play(Cell startCell) {
        index = (index + 1) % availableColors.size();
        return availableColors.get(index);
    }


}
