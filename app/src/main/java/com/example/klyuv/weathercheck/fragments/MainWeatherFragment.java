package com.example.klyuv.weathercheck.fragments;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.klyuv.weathercheck.events.MessageEvent;
import com.example.klyuv.weathercheck.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainWeatherFragment extends android.support.v4.app.Fragment {

    private TextView fm_tv_cityName, fm_tv_cityTemp;
    private ImageView fm_iv_weatherImage;

    public MainWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_weather, container, false);
//        ConstraintLayout fcl = (ConstraintLayout) view.findViewById(R.id.main_fragment_layout);

        fm_tv_cityName = (TextView) view.findViewById(R.id.fragment_main_weather_cityNameText);
        fm_tv_cityTemp = (TextView) view.findViewById(R.id.fragment_main_weather_cityTempText);
        fm_iv_weatherImage = (ImageView) view.findViewById(R.id.fragment_main_weather_imageView);

        return view;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){
        fm_tv_cityName.setText(event.name);
        if (event.temperature.get(0).first > 0){
            fm_tv_cityTemp.setText("+" + Double.toString(event.temperature.get(0).first)+ " °C");
        }else fm_tv_cityTemp.setText(Double.toString(event.temperature.get(0).first)+ " °C");

        if (event.temperature.get(0).second == 1){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_day_sunny);
        }else if (event.temperature.get(0).second == 2){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_day_rain);
        }else if (event.temperature.get(0).second == 3){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_day_rain_mix);
        }else if (event.temperature.get(0).second == 4){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_day_cloudy_windy);
        }else if (event.temperature.get(0).second == 5){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_snowflake_cold);
        }else if (event.temperature.get(0).second == 6){
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_meteor);
        }
        else{
            fm_iv_weatherImage.setBackgroundResource(R.drawable.ic_wi_alien);
        }
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
