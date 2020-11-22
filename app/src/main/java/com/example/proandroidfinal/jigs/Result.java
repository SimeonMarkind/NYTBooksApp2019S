package com.example.proandroidfinal.jigs;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("publication_dt")
    @Expose
    private String publicationDt;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("book_title")
    @Expose
    private String bookTitle;
    @SerializedName("book_author")
    @Expose
    private String bookAuthor;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("isbn13")
    @Expose
    private List<String> isbn13 = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param summary
     * @param bookAuthor
     * @param bookTitle
     * @param byline
     * @param isbn13
     * @param uuid
     * @param uri
     * @param url
     * @param publicationDt
     */
    public Result(String url, String publicationDt, String byline, String bookTitle, String bookAuthor, String summary, String uuid, String uri, List<String> isbn13) {
        super();
        this.url = url;
        this.publicationDt = publicationDt;
        this.byline = byline;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.summary = summary;
        this.uuid = uuid;
        this.uri = uri;
        this.isbn13 = isbn13;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Result withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicationDt() {
        return publicationDt;
    }

    public void setPublicationDt(String publicationDt) {
        this.publicationDt = publicationDt;
    }

    public Result withPublicationDt(String publicationDt) {
        this.publicationDt = publicationDt;
        return this;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public Result withByline(String byline) {
        this.byline = byline;
        return this;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Result withBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Result withBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Result withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Result withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Result withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public List<String> getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(List<String> isbn13) {
        this.isbn13 = isbn13;
    }

    public Result withIsbn13(List<String> isbn13) {
        this.isbn13 = isbn13;
        return this;
    }

}
