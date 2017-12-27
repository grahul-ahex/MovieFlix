package com.movieflix.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Asus on 12/12/2017.
 */

public class MyPreferenceManager {
    private static final String PREF_NAME = "movieflix_welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static Context mcontext;
//    private SharedPreferences pref;
//    private SharedPreferences.Editor editor;

    public MyPreferenceManager(Context context) {
        this.mcontext = context;
//        pref = mcontext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//        editor = pref.edit();
    }

    public static boolean isFirstTimeLaunch() {
        return (mcontext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)).getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public static void setFirstTimeLaunch(boolean isFirstTime) {
        (mcontext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)).edit().putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime).commit();
    }

}
