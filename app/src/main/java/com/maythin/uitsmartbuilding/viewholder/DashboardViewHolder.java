package com.maythin.uitsmartbuilding.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maythin.uitsmartbuilding.R;

/**
 * Created by mt on 10/1/18.
 */

public class DashboardViewHolder extends RecyclerView.ViewHolder {
    public TextView lab_name,lab_company;

    public DashboardViewHolder(View itemView) {
        super(itemView);
        lab_name=(TextView)itemView.findViewById(R.id.lab_temp);
        lab_company=(TextView)itemView.findViewById(R.id.lab_company);

    }
}
