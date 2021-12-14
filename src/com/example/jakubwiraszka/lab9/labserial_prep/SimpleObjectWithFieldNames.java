package com.example.jakubwiraszka.lab9.labserial_prep;

import com.google.gson.annotations.SerializedName;

public class SimpleObjectWithFieldNames {
    @SerializedName("Identifier")
    private int id;

    @SerializedName("Name")
    private String value;

    public SimpleObjectWithFieldNames(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
