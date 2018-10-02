package com.maythin.uitsmartbuilding.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maythin.uitsmartbuilding.R;

/**
 * Created by mt on 10/1/18.
 */

public class DashboardViewHolder extends RecyclerView.ViewHolder {
    public TextView lab_temp,lab_light,lab_event,lab_battery;
    public LinearLayout linear_view;

    public DashboardViewHolder(View itemView) {
        super(itemView);
        lab_temp=itemView.findViewById(R.id.lab_temp);
        lab_light=itemView.findViewById(R.id.lab_light);
        lab_event=itemView.findViewById(R.id.lab_event);
        lab_battery=itemView.findViewById(R.id.lab_battery);
        linear_view=itemView.findViewById(R.id.linear_view);

    }
}
