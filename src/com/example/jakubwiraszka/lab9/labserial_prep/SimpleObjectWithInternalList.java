package com.example.jakubwiraszka.lab9.labserial_prep;

import java.util.ArrayList;
import java.util.List;

public class SimpleObjectWithInternalList {
    private int id;
    private List<String> value = new ArrayList<>();

    public SimpleObjectWithInternalList(int id) {
        this.id = id;
        this.value.add("value1");
        this.value.add("value2");
    }
}
