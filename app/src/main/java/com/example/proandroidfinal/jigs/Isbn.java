package com.example.proandroidfinal.jigs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Isbn {

    @SerializedName("isbn10")
    @Expose
    private String isbn10;
    @SerializedName("isbn13")
    @Expose
    private String isbn13;

    /**
     * No args constructor for use in serialization
     */
    public Isbn() {
    }

    /**
     * @param isbn10
     * @param isbn13
     */
    public Isbn(String isbn10, String isbn13) {
        super();
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public Isbn withIsbn10(String isbn10) {
        this.isbn10 = isbn10;
        return this;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Isbn withIsbn13(String isbn13) {
        this.isbn13 = isbn13;
        return this;
    }

}