package com.movieflix.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movieflix.R;
import com.movieflix.adapters.RecyclerAdapterMovieCast;
import com.movieflix.datamodel.CastModel;

import java.util.ArrayList;

/**
 * Created by compindia-fujitsu on 06-12-2017.
 */

public class MovieDetailsCastFragment extends Fragment {
    RecyclerAdapterMovieCast recyclerAdapterMovieCast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_cast_page, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rvMovieCast);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new
                DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        try {
            recyclerAdapterMovieCast = new RecyclerAdapterMovieCast(getContext(), (ArrayList<CastModel>) getArguments().getSerializable("cast"));
            recyclerView.setAdapter(recyclerAdapterMovieCast);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Cast", "Error at set fragment");
        }
        return rootView;
    }
}
