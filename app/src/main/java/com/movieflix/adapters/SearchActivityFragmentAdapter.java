package com.movieflix.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Asus on 11/30/2017.
 */

public class SearchActivityFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;


    public SearchActivityFragmentAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        fragmentArrayList = arrayList;

    }

    @Override
    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//
//        }
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
