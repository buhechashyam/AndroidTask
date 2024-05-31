package com.example.ecommerceapp_webservice.model;
public class MovieModel {
    private String title;
    private String director;
    private int year;
    private String genre;
    private double rating;

    public MovieModel() {
    }

    public MovieModel(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public MovieModel(String title, String director, int year, String genre, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
