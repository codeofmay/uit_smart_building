package com.maythin.uitsmartbuilding.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maythin.uitsmartbuilding.POJO.SensorData;
import com.maythin.uitsmartbuilding.R;
import com.maythin.uitsmartbuilding.databinding.FragmentCurrentBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentFragment extends Fragment {

    FragmentCurrentBinding binding;
    TextView lab_temp,lab_event,lab_light,lab_battery;
    LinearLayout linear_interval,linear_setup,linear_botton,linear_motion;
    public CurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SensorData");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               /// This method is called once with the initial value and again
                // whenever data at this location is updated.
                SensorData sensorData = dataSnapshot.getValue(SensorData.class);
                lab_temp.setText(sensorData.getTemperature()+"");
                lab_battery.setText(sensorData.getBattery()+"");
                lab_event.setText(sensorData.getEvent()+"");
                lab_light.setText(sensorData.getLight()+"");
                switch (sensorData.getEvent()){
                    case "interval":
                        linear_interval.setBackgroundColor(getResources().getColor(R.color.Red));
                        linear_setup.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_motion.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_botton.setBackgroundColor(getResources().getColor(R.color.disable));
                        break;

                    case "setup":
                        linear_setup.setBackgroundColor(getResources().getColor(R.color.pending));
                        linear_interval.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_motion.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_botton.setBackgroundColor(getResources().getColor(R.color.disable));
                        break;
                    case "botton":
                        linear_botton.setBackgroundColor(getResources().getColor(R.color.orange));
                        linear_setup.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_motion.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_interval.setBackgroundColor(getResources().getColor(R.color.disable));
                        break;
                    case "motion":
                        linear_motion.setBackgroundColor(getResources().getColor(R.color.accepted));
                        linear_setup.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_interval.setBackgroundColor(getResources().getColor(R.color.disable));
                        linear_botton.setBackgroundColor(getResources().getColor(R.color.disable));
                        break;
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current, container, false);
        View v = binding.getRoot();
        lab_battery=binding.labBattery;
        lab_event=binding.labEvent;
        lab_light=binding.labLight;
        lab_temp=binding.labTemp;

        linear_interval=binding.linearInterval;
        linear_botton=binding.linearBotton;
        linear_motion=binding.linearMotion;
        linear_setup=binding.linearSetup;

        return v;
    }

}
