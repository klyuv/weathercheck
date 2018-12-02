package com.example.klyuv.weathercheck.events;

import android.graphics.Paint;
import android.util.Pair;

import com.example.klyuv.weathercheck.model.TempList;

import java.util.ArrayList;
import java.util.List;

public class MessageEvent{

    public final String name;
    public final ArrayList<Pair<Double, Integer>> temperature;

    public MessageEvent(String name, ArrayList<Pair<Double, Integer>> temperature) {
        this.name = name;
        this.temperature = temperature;
    }

}