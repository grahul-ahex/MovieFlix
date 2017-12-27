package com.movieflix.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.movieflix.R;
import com.movieflix.datamodel.MovieModel;

import java.util.ArrayList;

import static com.movieflix.interfaces.ConstUtils.imageURL;

/**
 * Created by Asus on 12/8/2017.
 */

public class RecyclerAdapterMovieCredits extends RecyclerView.Adapter<RecyclerAdapterMovieCredits.MyViewHolder> {
    private Context mContext;
    private ArrayList<MovieModel> movieModels;

    public RecyclerAdapterMovieCredits(Context context, ArrayList<MovieModel> arrayList) {
        this.mContext = context;
        this.movieModels = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String url = imageURL + (movieModels.get(position).getPosterPath());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.error_image_1);
        Glide.with(mContext).setDefaultRequestOptions(requestOptions).load(url).into(holder.imageView);
        holder.textView.setText(movieModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_recycler_item_home);
            textView = itemView.findViewById(R.id.tv_recycler_item_home);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}

