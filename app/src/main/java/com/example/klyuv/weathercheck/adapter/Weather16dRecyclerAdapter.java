package com.example.klyuv.weathercheck.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.klyuv.weathercheck.R;
import com.example.klyuv.weathercheck.model.City;

import java.util.ArrayList;
import java.util.List;

public class Weather16dRecyclerAdapter extends RecyclerView.Adapter<Weather16dRecyclerAdapter.ViewHolder> {

    private ArrayList<Pair<Double, Integer>> mList;
    private Context mContext;

    public void setItems(ArrayList<Pair<Double, Integer>> temp){
        mList.addAll(temp);
        notifyDataSetChanged();
    }

    public Weather16dRecyclerAdapter(ArrayList<Pair<Double, Integer>> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather16d_form, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mList.get(position);

        if (mList.get(position).first >= 0){
            holder.tempText.setText("+" + Double.toString(mList.get(position).first) + " °C");
        }else {
            holder.tempText.setText(Double.toString(mList.get(position).first) + " °C");
        }

        if (mList.get(position).second == 1){
            holder.imageView.setImageResource(R.drawable.ic_wi_day_sunny);
        }else if (mList.get(position).second == 2){
            holder.imageView.setImageResource(R.drawable.ic_wi_day_rain);
        }else if (mList.get(position).second == 3){
            holder.imageView.setImageResource(R.drawable.ic_wi_day_rain_mix);
        }else if (mList.get(position).second == 4){
            holder.imageView.setImageResource(R.drawable.ic_wi_day_cloudy_windy);
        }else if (mList.get(position).second == 5){
            holder.imageView.setImageResource(R.drawable.ic_wi_snowflake_cold);
        }else if (mList.get(position).second == 6){
            holder.imageView.setImageResource(R.drawable.ic_wi_meteor);
        }
        else{
            holder.imageView.setImageResource(R.drawable.ic_wi_alien);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tempText;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            tempText = itemView.findViewById(R.id.fragment_16d_form_tv_temperature);
            imageView = itemView.findViewById(R.id.fragment_16d_from_imageView);
        }

    }
}
