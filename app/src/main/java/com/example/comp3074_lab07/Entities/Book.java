package com.example.comp3074_lab07.Entities;

import androidx.annotation.NonNull;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    @NonNull
    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
