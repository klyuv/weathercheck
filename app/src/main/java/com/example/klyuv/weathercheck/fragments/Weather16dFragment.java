package com.example.klyuv.weathercheck.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.activity.MainActivity;
import com.example.klyuv.weathercheck.activity.WeatherActivity;
import com.example.klyuv.weathercheck.adapter.CityRecyclerAdapter;
import com.example.klyuv.weathercheck.adapter.Weather16dRecyclerAdapter;
import com.example.klyuv.weathercheck.events.MessageEvent;
import com.example.klyuv.weathercheck.model.City;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class Weather16dFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Double> mDoublesList;
    private Weather16dRecyclerAdapter mWeather16dRecyclerAdapter;
    private TextView mTextView;

    public Weather16dFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather16d, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_16d_recyclerView);
//        mWeather16dRecyclerAdapter.setItems(mDoublesList);

        return view;
    }

    private void doStuff(){
//        mCities = new ArrayList<>();
//        mCityRecycler.setLayoutManager(new LinearLayoutManager(this));
//        mCityRecyclerAdapter = new CityRecyclerAdapter(mCities, getApplication(), new CityRecyclerAdapter.OnCityClickListener() {
//            @Override
//            public void onCityClicked(City city, int position) {
//                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
//                startActivity(intent);
//            }
//        });
//        mCityRecycler.setAdapter(mCityRecyclerAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
////        mWeather16dRecyclerAdapter = new Weather16dRecyclerAdapter(mDoublesList);
//        recyclerView.setAdapter(mWeather16dRecyclerAdapter);

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.ASYNC)
    public void onEvent(MessageEvent event){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mWeather16dRecyclerAdapter = new Weather16dRecyclerAdapter(event.temperature);
        recyclerView.setAdapter(mWeather16dRecyclerAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
