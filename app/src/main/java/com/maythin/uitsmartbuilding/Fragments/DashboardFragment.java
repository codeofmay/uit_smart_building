package com.maythin.uitsmartbuilding.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maythin.uitsmartbuilding.POJO.SensorModel;
import com.maythin.uitsmartbuilding.R;
import com.maythin.uitsmartbuilding.adapter.DashboardAdapter;
import com.maythin.uitsmartbuilding.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    public RecyclerView recycler_dashboard;
    public ArrayList<SensorModel> list = new ArrayList<>();
    DashboardAdapter dashboardAdapter;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        View v = binding.getRoot();
        getData();
        recycler_dashboard=binding.recyclerDashboard;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recycler_dashboard.setLayoutManager(linearLayoutManager);

        dashboardAdapter=new DashboardAdapter(list);
        recycler_dashboard.setAdapter(dashboardAdapter);
        return v;
    }

    public ArrayList<SensorModel> getData(){
        list.clear();
        for (int i=0;i<20;i++){
            SensorModel sensorModel=new SensorModel();
            sensorModel.setBattery(34567);
            list.add(sensorModel);
        }
        return list;
    }

}
