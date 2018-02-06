package com.movieflix.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import com.movieflix.activities.HomeActivity;

/**
 * Created by rahul-asus on 03-12-2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
//    private LayoutInflater inflater;
//    private Context context;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        return HomeActivity.PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

}
