package com.example.jakubwiraszka.lab5;

public class Main {

    public static void main(String[] args) {
        ColorfulPen colorfulPen = new ColorfulPen();
        colorfulPen.setTurnedOn(true);
        colorfulPen.setChosenColor(Color.BLACK);
        PenCase penCase = new PenCase();
        penCase.putPen(colorfulPen);
        penCase.setChosenPen(colorfulPen);
        penCase.write("Coś tam");
    }
}
