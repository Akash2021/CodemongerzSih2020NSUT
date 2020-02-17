package com.example.ml_vision;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FirReport
{
    @SerializedName("Properties")
    @Expose
    private List<String> Properties = new ArrayList<>();
    @SerializedName("Value")
    @Expose
    private List<String> Value = new ArrayList<>();

    public List<String> getProperties() {
        return Properties;
    }

    public void setProperties(List<String> properties) {
        Properties = properties;
    }

    public List<String> getValue() {
        return Value;
    }

    public void setValue(List<String> value) {
        Value = value;
    }
}
