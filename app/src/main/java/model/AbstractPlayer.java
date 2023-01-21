package model;

public abstract  class AbstractPlayer implements Player{

    private String name;
    private final Cell startCell;

    public AbstractPlayer(String name, Cell startCell){
        setName(name);
        this.startCell = startCell;
    }

    public AbstractPlayer(Cell startCell){
        this("player", startCell);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Cell getStartCell(){
        return this.startCell;
    }
}
