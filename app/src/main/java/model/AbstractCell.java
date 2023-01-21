package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * This class provides a partial implementation of the {@code Cell} interface.
 *
 */
public abstract class AbstractCell implements Cell{

    static final Color DEFAULT_CELL_COLOR = Color.LIGHTGRAY;
    private final ObjectProperty<Color> colorProperty = new SimpleObjectProperty<>(DEFAULT_CELL_COLOR);


    public AbstractCell(){}
    /**
     * The constructor of {@code AbstractCell}
     * @param color the color of the cell
     */
    public AbstractCell(Color color){
        setColor(color);
    }


    @Override
    public void setColor(Color color){
        colorProperty.setValue(color);
    }

    @Override
    public Color getColor(){
        return colorProperty.getValue();
    }

    @Override
    public ObjectProperty<Color> getColorProperty(){
        return colorProperty;
    }


}
