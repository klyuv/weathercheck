package com.example.klyuv.weathercheck.model;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class City {

    int id;
    String name;
    ArrayList<Pair<Double, Integer>> temp;
    ArrayList<TempList> mTempListArrayList;

    public City(int id, String name, ArrayList<Pair<Double, Integer>> temp) {
        this.id = id;
        this.name = name;
        this.temp = temp;
    }

//    public City(int id, String name, ArrayList<TempList> tempListArrayList) {
//        this.id = id;
//        this.name = name;
//        mTempListArrayList = tempListArrayList;
//    }

    public ArrayList<TempList> getTempListArrayList() {
        return mTempListArrayList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pair<Double, Integer>> getTemp() {
        return temp;
    }
}
