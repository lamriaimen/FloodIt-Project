package model;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FloodGame  {

    private  Player player;
    private final int totalFloodingArea;
    private final SimpleIntegerProperty turn  = new SimpleIntegerProperty(0);

    public FloodGame(int totalFloodingArea){
        this.totalFloodingArea = totalFloodingArea;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void setTurn(int value){
        turn.setValue(value);
    }

    public int  getTurn(){
        return turn.getValue();
    }

    public void  resetTurn() {
        setTurn(0);
    }

    public SimpleIntegerProperty getTurnProperty(){
        return turn;
    }

    public void incrementTurn(){
        setTurn(getTurn()+1);
    }

    public boolean isHumanTurn(){
        return getPlayer().isHuman();
    }


    public int getPlayerScore(Player player) {

        return Flooder.coloredArea ( player.getStartCell () );
    }

    public boolean hasWon(Player player){
        return getPlayerScore ( player )==totalFloodingArea;
    }

    public boolean hasEnded(){

        return hasWon ( player )||(getTurn ()>=totalFloodingArea);
    }


}
