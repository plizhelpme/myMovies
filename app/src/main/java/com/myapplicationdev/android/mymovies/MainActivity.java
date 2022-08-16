package com.myapplicationdev.android.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    Button btnInsert;
    Button btnShow;
    Spinner spnRating;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;
    ListView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.editTextTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spnRating = findViewById(R.id.spinnerRating);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        lvMovie = findViewById(R.id.lvMovie);

        alMovieList = new ArrayList<>();
        Movie item1 = new Movie("Orphan", "Horror", "2009", "M18");
        alMovieList.add(item1);
        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spnRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        switch (position){
                            case 0:
                                alMovieList.add(new Movie(etTitle.getText().toString(), etGenre.getText().toString(),
                                        etYear.getText().toString(), adapterView.getItemAtPosition(position).toString()));
                                caMovie.notifyDataSetChanged();
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowMovie.class);
                startActivity(i);
            }
        });
    }
}