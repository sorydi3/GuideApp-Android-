package com.example.android.guideapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    public static String resto;
    public static String hotel;
    public static String museum;
    public static String atm;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atm = getString(R.string.ATM);
        resto = getString(R.string.RESTO);
        hotel = getString(R.string.HOTEL);
        museum = getString(R.string.MUSEUM);
        //create a view pager to be able scroll right and left
        mViewpager = (ViewPager) findViewById(R.id.pager);
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        AdapterFragments adapter = new AdapterFragments(getSupportFragmentManager());
        mViewpager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewpager);

    }
}
