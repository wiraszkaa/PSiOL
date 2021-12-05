package com.example.jakubwiraszka.lab5;

public class TurnablePen extends Pen {

    protected boolean turnedOn;

    @Override
    public void write(String text) {
        if(turnedOn) {
            super.write(text);
        }
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }
}
