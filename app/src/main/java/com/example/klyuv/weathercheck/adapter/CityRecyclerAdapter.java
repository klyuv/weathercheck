package com.example.klyuv.weathercheck.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.klyuv.weathercheck.events.MessageEvent;
import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.model.City;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.CityViewHolder> {

    private List<City> mCities = new ArrayList<>();
    private Context mContext;

    private OnCityClickListener listener;

    private int selectedPos;

    public CityRecyclerAdapter(List<City> cities, Context context, OnCityClickListener listener) {
        mCities = cities;
        mContext = context;
        this.listener = listener;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_form, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        City city = mCities.get(position);

        //1 - sun
        //2 - rain
        //3 - rain + snow
        //4 - wind
        //5 - cold
        //6 - meteor

        holder.cityNameText.setText(city.getName());
        if (city.getTemp().get(0).first > 0){
            holder.cityTempText.setText("+" + Double.toString(city.getTemp().get(0).first ) + " °C");
        }else holder.cityTempText.setText(Double.toString(city.getTemp().get(0).first ) + " °C");

        if (city.getTemp().get(0).second == 1){
            holder.cityImage.setImageResource(R.drawable.ic_wi_day_sunny);
        }else if (city.getTemp().get(0).second == 2){
            holder.cityImage.setImageResource(R.drawable.ic_wi_day_rain);
        }else if (city.getTemp().get(0).second == 3){
            holder.cityImage.setImageResource(R.drawable.ic_wi_day_rain_mix);
        }else if (city.getTemp().get(0).second== 4){
            holder.cityImage.setImageResource(R.drawable.ic_wi_day_cloudy_windy);
        }else if (city.getTemp().get(0).second == 5){
            holder.cityImage.setImageResource(R.drawable.ic_wi_snowflake_cold);
        }else if (city.getTemp().get(0).second == 6){
            holder.cityImage.setImageResource(R.drawable.ic_wi_meteor);
        }
        else{
            holder.cityImage.setBackgroundResource(R.drawable.ic_wi_alien);
        }

        holder.bind(city, listener);
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }


    public class CityViewHolder extends RecyclerView.ViewHolder {

        private TextView cityNameText;
        private TextView cityTempText;
        private ImageView cityImage;

        public CityViewHolder(View itemView) {
            super(itemView);

            cityNameText = itemView.findViewById(R.id.city_main_name);
            cityTempText = itemView.findViewById(R.id.city_main_temperature);
            cityImage = itemView.findViewById(R.id.city_main_image);
        }

        public void bind(final City city, final OnCityClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCityClicked(city, getLayoutPosition());
                    EventBus.getDefault().postSticky(new MessageEvent(city.getName(), city.getTemp()));
                }
            });
        }
    }

//    public void setItems(Collection<City> cities){
//        mCities.addAll(cities);
//        notifyDataSetChanged();
//    }
//
//    public void clearItems(){
//        mCities.clear();
//        notifyDataSetChanged();
//    }

    public interface OnCityClickListener{
        void onCityClicked(City city, int position);
    }

    public void setSelectedPos(int selectedPos) {
        this.selectedPos = selectedPos;
    }

    public int getSelectedPos() {
        return selectedPos;
    }

}
