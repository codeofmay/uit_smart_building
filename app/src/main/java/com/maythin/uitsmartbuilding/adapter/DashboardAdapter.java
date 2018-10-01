package com.maythin.uitsmartbuilding.adapter;

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

    public DashboardAdapter(ArrayList<SensorModel> list){
        this.list = list;
    }
    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        DashboardViewHolder dashboardViewHolder=new DashboardViewHolder(v);

        return dashboardViewHolder;
    }

    @Override
    public void onBindViewHolder(DashboardViewHolder holder, int position) {
        holder.lab_company.setText(list.get(position).getBattery()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
