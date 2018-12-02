package com.example.klyuv.weathercheck.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.fragments.MainWeatherFragment;
import com.example.klyuv.weathercheck.fragments.Weather16dFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private Context context;


    public SectionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainWeatherFragment();
            case 1:
                return new Weather16dFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getText(R.string.tab_main);
            case 1:
                return context.getResources().getText(R.string.tab_16d);
        }
        return null;
    }
}
