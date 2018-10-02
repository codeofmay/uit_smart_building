package com.maythin.uitsmartbuilding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maythin.uitsmartbuilding.POJO.SensorModel;
import com.maythin.uitsmartbuilding.R;
import com.maythin.uitsmartbuilding.viewholder.DashboardViewHolder;

import java.util.ArrayList;

/**
 * Created by mt on 10/1/18.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    private ArrayList<SensorModel> list;
    Context context;

    public DashboardAdapter(Context context,ArrayList<SensorModel> list){
        this.list = list;
        this.context=context;
    }
    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        DashboardViewHolder dashboardViewHolder=new DashboardViewHolder(v);

        return dashboardViewHolder;
    }

    @Override
    public void onBindViewHolder(DashboardViewHolder holder, int position) {
        holder.lab_temp.setText(list.get(position).getTemperature()+" temperature");
        holder.lab_light.setText(list.get(position).getLight()+" light");
        holder.lab_event.setText(list.get(position).getEvent()+" event");
        holder.lab_battery.setText(list.get(position).getBattery()+" battery");
        switch (list.get(position).getEvent()){
            case "internal":
                holder.linear_view.setBackgroundColor(context.getResources().getColor(R.color.Red));
                break;
            case "setup":
                holder.linear_view.setBackgroundColor(context.getResources().getColor(R.color.pending));
                break;
            case "botton":
                holder.linear_view.setBackgroundColor(context.getResources().getColor(R.color.orange));
                break;
            case "motion":
                holder.linear_view.setBackgroundColor(context.getResources().getColor(R.color.accepted));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
