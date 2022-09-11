package com.example.newsx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome,mScience,mTech,mEnter,mHealth,mSports;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    String apiKey = "420036202ee54283bb65192a5175039b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        mHealth = findViewById(R.id.health);
        mScience = findViewById(R.id.science);
        mSports = findViewById(R.id.sports);
        mHome = findViewById(R.id.home);
        mTech = findViewById(R.id.tech);
        mEnter = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);

        pagerAdapter = new pagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int n = tab.getPosition();
                viewPager.setCurrentItem(n);

                if (n >= 0 && n <= 5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}