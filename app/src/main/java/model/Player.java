package model;

public interface Player   {

    void setName(String name);
    String getName();
    Cell getStartCell();
    boolean isHuman();
}
