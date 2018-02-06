package com.movieflix.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by rahul-asus on 12/6/2017.
 */

public class ActorDetailsAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> actorDetailsArrayList = new ArrayList<>();

    public ActorDetailsAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        actorDetailsArrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment=actorDetailsArrayList.get(0);
                return fragment;
            case 1:
                fragment=actorDetailsArrayList.get(1);
                return fragment;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return actorDetailsArrayList.size();
    }
}
