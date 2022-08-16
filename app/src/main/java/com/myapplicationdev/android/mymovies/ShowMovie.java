package com.myapplicationdev.android.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowMovie extends AppCompatActivity {

    Movie data;
    CustomAdapter caMovie;
    ArrayList<Movie> alMovieList;
    ListView lvMovie;
    Button btnFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie);

        btnFilter = findViewById(R.id.btnFilter);
        lvMovie = findViewById(R.id.lvMovie);

        Intent i = getIntent();
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(ShowMovie.this, UpdateMovie.class);
                startActivity(x);
            }
        });

    }
}
