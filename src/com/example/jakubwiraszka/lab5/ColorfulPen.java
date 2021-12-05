package com.example.jakubwiraszka.lab5;


public class ColorfulPen extends TurnablePen {

    private Color chosenColor;

    public ColorfulPen() {

    }

    @Override
    public void write(String text) {
        if(super.turnedOn) {
            System.out.println("<" + chosenColor + ">" + text + "</" + chosenColor + ">");
        }
    }

    public void setChosenColor(Color color) {
        this.chosenColor = color;
    }
}
