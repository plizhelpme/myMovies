package com.myapplicationdev.android.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateMovie extends AppCompatActivity {

    ArrayList<Movie> alMovie;
    EditText title;
    EditText genre;
    EditText year;
    Spinner spnRating;
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);

        title = findViewById(R.id.edittTitle);
        genre = findViewById(R.id.edittGenre);
        year = findViewById(R.id.edittYear);
        spnRating = findViewById(R.id.spinnerRating);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 0; x < alMovie.size(); x++) {
                    alMovie.get(x).setTitle(title.getText().toString());
                    alMovie.get(x).setGenre(genre.getText().toString());
                    alMovie.get(x).setYear(year.getText().toString());
                    alMovie.get(x).setRating(String.valueOf(spnRating));
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(UpdateMovie.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie " + title);
                myBuilder.setCancelable(true);
                myBuilder.setNegativeButton("CANCEL",null);
                myBuilder.setPositiveButton("DELETE",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(UpdateMovie.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want discard the changes");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("DISCARD",null);
                myBuilder.setNegativeButton("DO NOT DISCARD",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

    }
}
