package com.myapplicationdev.android.mymovies;

public class Movie {

    private String title;
    private String genre;
    private String year;
    private String rating;

    public Movie(String title, String genre, String year, String rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + '\'' +
                genre + '\'' +
                year +
                rating + '\'';
    }
}
