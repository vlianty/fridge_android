package com.example.fridge_app;

import android.util.Log;

import java.sql.*;

public class WeightSensor
{
    private double weight = 0;
    double getWeight()
    {
        return weight; //我不知道是不是要這樣，不是的話我再改
    }

    public void setWeight(double w)
    {
        weight = w;
    }

}