package com.maythin.uitsmartbuilding.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maythin.uitsmartbuilding.MethodUtils;
import com.maythin.uitsmartbuilding.POJO.DateModel;
import com.maythin.uitsmartbuilding.POJO.SensorModel;
import com.maythin.uitsmartbuilding.R;
import com.maythin.uitsmartbuilding.adapter.DashboardAdapter;
import com.maythin.uitsmartbuilding.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    public RecyclerView recycler_dashboard;
    public ArrayList<SensorModel> list = new ArrayList<>();
    DashboardAdapter dashboardAdapter;
    DatabaseReference dashboradRef,dateRef;
    SwipeRefreshLayout refresh_dashboard;
    FirebaseDatabase database;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        database = FirebaseDatabase.getInstance();
        checkDate();
        getData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        View v = binding.getRoot();

        recycler_dashboard = binding.recyclerDashboard;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_dashboard.setLayoutManager(linearLayoutManager);

        refresh_dashboard=binding.refreshDashboard;
        refresh_dashboard.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        return v;
    }

    public void getData() {

        dashboradRef = database.getReference("DashBoardData");
        dashboradRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot sensorSnapshot : dataSnapshot.getChildren()) {
                    SensorModel sensorModel = sensorSnapshot.getValue(SensorModel.class);
                    list.add(sensorModel);
                }
                dashboardAdapter = new DashboardAdapter(getContext(),list);
                recycler_dashboard.setAdapter(dashboardAdapter);
                refresh_dashboard.setRefreshing(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void checkDate(){
        //clear all data after one day
        dateRef = database.getReference("datecheck");
        dateRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DateModel dateModel=dataSnapshot.getValue(DateModel.class);
                if (!dateModel.getCurrentDate().equalsIgnoreCase(MethodUtils.getCurrentDate())){
                    dashboradRef.removeValue();
                    Map<String,Object> dateMap=new HashMap<>();
                    dateMap.put("currentDate",MethodUtils.getCurrentDate());
                    dateRef.updateChildren(dateMap);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
