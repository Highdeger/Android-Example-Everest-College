package com.example.www.androideverest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabbedActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        tabLayout = findViewById(R.id.tabbed_tablayout);
        viewPager = findViewById(R.id.tabbed_viewpager);

        TabbedViewPagerAdapter adapter = new TabbedViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabbedFragmentOne(), "Tab1");
        adapter.addFragment(new TabbedFragmentTwo(), "Tab2");
        adapter.addFragment(new TabbedFragmentThree(), "Tab3");
        adapter.addFragment(new TabbedFragmentOne(), "Tab4");
        adapter.addFragment(new TabbedFragmentTwo(), "Tab5");
        adapter.addFragment(new TabbedFragmentThree(), "Tab6");
        adapter.addFragment(new TabbedFragmentOne(), "Tab7");
        adapter.addFragment(new TabbedFragmentTwo(), "Tab8");
        adapter.addFragment(new TabbedFragmentThree(), "Tab9");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
