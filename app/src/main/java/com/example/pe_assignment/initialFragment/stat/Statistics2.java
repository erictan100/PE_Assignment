package com.example.pe_assignment.initialFragment.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics2 {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
