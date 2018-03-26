package com.example.android.guideapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sam on 29/06/2017.
 */

public class AdapterFragments extends FragmentPagerAdapter {
    //array that store the titles of the fragments
    Context mcontext;
    final String Titles[] = {MainActivity.resto, MainActivity.hotel, MainActivity.museum, MainActivity.atm};
    static final int N_TABS = 4;

    public AdapterFragments(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                // The first section of the app is the most interesting -- it offers
                // a launchpad into the other demonstrations in this example application.
                return new FragmentRestaurant();
            case 1:
                return new FragmentHotels();
            case 2:
                return new FragmentsMuseums();
            case 3:
                return new FragmentsAtms();
        }
        return null;
    }

    @Override
    public int getCount() {
        return N_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

}
