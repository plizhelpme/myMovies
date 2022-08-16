package com.myapplicationdev.android.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        Button btnFilter = rowView.findViewById(R.id.btnFilter);
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        ImageView ivRating =rowView.findViewById(R.id.imageViewRating);

        Movie currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvGenre.setText(currentItem.getGenre());
        tvYear.setText(currentItem.getYear());

        if (currentItem.getRating() == "") {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRating() == ""){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if(currentItem.getRating() == ""){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRating() == ""){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentItem.getRating() == ""){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}


