package com.example.klyuv.weathercheck.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.adapter.SectionPagerAdapter;
import com.example.klyuv.weathercheck.events.MessageEvent;
import com.example.klyuv.weathercheck.fragments.MainWeatherFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class WeatherActivity extends AppCompatActivity {

    private ViewPager pager;
    private String test;
    private Context context;
    Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheather);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar1);
//        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragcont);

        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), WeatherActivity.this);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF4081"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#ffffff"));

//        Fragment fragment = new MainWeatherFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.add(R.id.fragcont, fragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}


