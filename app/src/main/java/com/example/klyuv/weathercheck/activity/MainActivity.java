package com.example.klyuv.weathercheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.adapter.CityRecyclerAdapter;
import com.example.klyuv.weathercheck.fragments.DialogFragmentChooseCity;
import com.example.klyuv.weathercheck.model.City;
import com.example.klyuv.weathercheck.model.TempList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ArrayList<City> mCities;
    private CityRecyclerAdapter mCityRecyclerAdapter;
    private RecyclerView mCityRecycler;
    private ArrayList<Double> mTempDouble;
    private ArrayList<TempList> mTempLists;
    private ArrayList<Pair<Double, Integer>> mPairArrayList;

    DialogFragment dlg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dlg1 = new DialogFragmentChooseCity();

        mCityRecycler = (RecyclerView) findViewById(R.id.cityRecycler);
        doStuff();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                dlg1.show(getSupportFragmentManager(), "dlg1");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doStuff(){
        mCities = new ArrayList<>();
        mCityRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCityRecyclerAdapter = new CityRecyclerAdapter(mCities, getApplication(), new CityRecyclerAdapter.OnCityClickListener() {
            @Override
            public void onCityClicked(City city, int position) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });
        mCityRecycler.setAdapter(mCityRecyclerAdapter);
        getCityList();
    }

    public void getCityList(){
        //1 - sun
        //2 - rain
        //3 - rain + snow
        //4 - wind
        //5 - cold
        //6 - meteor
        mCities.add(new City(0, "Krasnoyarsk", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(13.4, 1),
                new Pair<>(3.0, 2),
                new Pair<>(4.0, 2),
                new Pair<>(5.0, 4),
                new Pair<>(10.1, 1)))));

        mCities.add(new City(1, "New York", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(14.0, 1),
                new Pair<>(23.0, 1),
                new Pair<>(25.0, 6),
                new Pair<>(6.1, 2),
                new Pair<>(1.1, 2)))));

        mCities.add(new City(2, "Norilsk", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(-10.4, 5),
                new Pair<>(-5.6, 3),
                new Pair<>(-4.3, 3),
                new Pair<>(2.0, 3),
                new Pair<>(0.0, 10)))));

        mCities.add(new City(3, "Novosibirks", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(12.4, 1),
                new Pair<>(21.2, 6),
                new Pair<>(15.5, 2),
                new Pair<>(5.0, 2),
                new Pair<>(3.8, 2)))));

        mCities.add(new City(5, "asfaf", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(2.2, 3),
                new Pair<>(3.5, 11),
                new Pair<>(4.1, 1),
                new Pair<>(5.3, 1),
                new Pair<>(6.2, 2)))));

        mCities.add(new City(21, "safsf", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(1.1, 1),
                new Pair<>(2.2, 3),
                new Pair<>(0.0, 111)))));

        mCities.add(new City(25, "afafa2faf", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(1.2, 10),
                new Pair<>(3.4, 1)))));

        mCities.add(new City(234, "Kekekek", mPairArrayList = new ArrayList<>(Arrays.asList(
                new Pair<>(3.2, 1),
                new Pair<>(3.3, 1)))));
//        mCities.add(new City(222, "a2faf2f", mTempLists = new ArrayList<>(Arrays.asList(
//                new TempList(10.2, 3),
//                new TempList(11.1, 3)))));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
