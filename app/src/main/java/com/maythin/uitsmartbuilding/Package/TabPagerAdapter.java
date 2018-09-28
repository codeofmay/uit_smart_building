package com.maythin.uitsmartbuilding.Package;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maythin.uitsmartbuilding.Fragments.CurrentFragment;
import com.maythin.uitsmartbuilding.Fragments.DashboardFragment;

/**
 * Created by mt on 9/28/18.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CurrentFragment();
            case 1:
                return new DashboardFragment();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
