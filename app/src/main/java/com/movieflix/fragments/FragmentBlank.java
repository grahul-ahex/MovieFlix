package com.movieflix.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.movieflix.R;
import com.movieflix.interfaces.HandlingSearchResults;


/**
 * Created by Asus on 12/11/2017.
 */

public class FragmentBlank extends Fragment implements HandlingSearchResults {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_blank,container,false);
        return view;
    }

    @Override
    public void handleSearchResults(String searchQuery) {

//        Toast.makeText(getContext(), searchQuery, Toast.LENGTH_SHORT).show();
        view.setVisibility(View.VISIBLE);
    }
}
