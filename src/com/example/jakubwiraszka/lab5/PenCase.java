package com.example.jakubwiraszka.lab5;

import java.util.ArrayList;
import java.util.List;

public class PenCase {
    private List<Pen> pens;
    private Pen chosenPen;

    public PenCase() {
        this.pens = new ArrayList<>();
    }

    public void putPen(Pen pen) {
        pens.add(pen);
    }

    public void setChosenPen(Pen pen) {
        chosenPen = pen;
    }

    public void write(String text) {
        chosenPen.write(text);
    }
}
