package com.example.proandroidfinal.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "book_table",
        indices = {@Index(value = {"title", "author"})})
public class BookEntry {

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "author")
    private String author;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "ISBN13")
    private String ISBN13;

    @ColumnInfo(name = "image_url")
    private String imageURL;

    public BookEntry(
            @NonNull String title,
            @NonNull String author,
            @NonNull String ISBN13,
            String imageURL) {
        this.author = author;
        this.imageURL = imageURL;
        this.ISBN13 = ISBN13;
        this.title = title;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getISBN13() {
        return ISBN13;
    }

    public String getImageURL() {
        return imageURL;
    }

    @NonNull
    public String getBookEntry() {
        final String s = getTitle() +
                getAuthor() +
                getISBN13() +
                getImageURL();
        return s;
    }
}
