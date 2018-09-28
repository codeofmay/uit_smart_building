package com.maythin.uitsmartbuilding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maythin.uitsmartbuilding.Package.TabPagerAdapter;
import com.maythin.uitsmartbuilding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    TabPagerAdapter tabPagerAdapter;
    ViewPager viewPager;
    ActivityMainBinding binding;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewPager=binding.container;
        tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);


       /* mTextMessage = (TextView) findViewById(R.id.message);*/
        BottomNavigationView navigation = binding.navigation;

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
