package com.movieflix.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * Created by rahul-asus on 06-12-2017.
 */

public class MovieDetailsSectionAdapter extends FragmentPagerAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<Fragment> fragmentArrayList;

    public MovieDetailsSectionAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.context = context;
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
