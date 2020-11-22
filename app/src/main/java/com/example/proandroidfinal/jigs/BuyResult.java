
package com.example.proandroidfinal.jigs;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BuyResult {

    @SerializedName("list_name")
    @Expose
    private String listName;
    @SerializedName("list_name_encoded")
    @Expose
    private String listNameEncoded;
    @SerializedName("bestsellers_date")
    @Expose
    private String bestsellersDate;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("published_date_description")
    @Expose
    private String publishedDateDescription;
    @SerializedName("next_published_date")
    @Expose
    private String nextPublishedDate;
    @SerializedName("previous_published_date")
    @Expose
    private String previousPublishedDate;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("normal_list_ends_at")
    @Expose
    private Integer normalListEndsAt;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("books")
    @Expose
    private List<Book> books = null;
    @SerializedName("corrections")
    @Expose
    private List<Object> corrections = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BuyResult() {
    }

    /**
     *
     * @param listNameEncoded
     * @param books
     * @param listName
     * @param updated
     * @param bestsellersDate
     * @param normalListEndsAt
     * @param publishedDateDescription
     * @param nextPublishedDate
     * @param corrections
     * @param publishedDate
     * @param displayName
     * @param previousPublishedDate
     */
    public BuyResult(String listName, String listNameEncoded, String bestsellersDate, String publishedDate, String publishedDateDescription, String nextPublishedDate, String previousPublishedDate, String displayName, Integer normalListEndsAt, String updated, List<Book> books, List<Object> corrections) {
        super();
        this.listName = listName;
        this.listNameEncoded = listNameEncoded;
        this.bestsellersDate = bestsellersDate;
        this.publishedDate = publishedDate;
        this.publishedDateDescription = publishedDateDescription;
        this.nextPublishedDate = nextPublishedDate;
        this.previousPublishedDate = previousPublishedDate;
        this.displayName = displayName;
        this.normalListEndsAt = normalListEndsAt;
        this.updated = updated;
        this.books = books;
        this.corrections = corrections;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public BuyResult withListName(String listName) {
        this.listName = listName;
        return this;
    }

    public String getListNameEncoded() {
        return listNameEncoded;
    }

    public void setListNameEncoded(String listNameEncoded) {
        this.listNameEncoded = listNameEncoded;
    }

    public BuyResult withListNameEncoded(String listNameEncoded) {
        this.listNameEncoded = listNameEncoded;
        return this;
    }

    public String getBestsellersDate() {
        return bestsellersDate;
    }

    public void setBestsellersDate(String bestsellersDate) {
        this.bestsellersDate = bestsellersDate;
    }

    public BuyResult withBestsellersDate(String bestsellersDate) {
        this.bestsellersDate = bestsellersDate;
        return this;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public BuyResult withPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public String getPublishedDateDescription() {
        return publishedDateDescription;
    }

    public void setPublishedDateDescription(String publishedDateDescription) {
        this.publishedDateDescription = publishedDateDescription;
    }

    public BuyResult withPublishedDateDescription(String publishedDateDescription) {
        this.publishedDateDescription = publishedDateDescription;
        return this;
    }

    public String getNextPublishedDate() {
        return nextPublishedDate;
    }

    public void setNextPublishedDate(String nextPublishedDate) {
        this.nextPublishedDate = nextPublishedDate;
    }

    public BuyResult withNextPublishedDate(String nextPublishedDate) {
        this.nextPublishedDate = nextPublishedDate;
        return this;
    }

    public String getPreviousPublishedDate() {
        return previousPublishedDate;
    }

    public void setPreviousPublishedDate(String previousPublishedDate) {
        this.previousPublishedDate = previousPublishedDate;
    }

    public BuyResult withPreviousPublishedDate(String previousPublishedDate) {
        this.previousPublishedDate = previousPublishedDate;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BuyResult withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public Integer getNormalListEndsAt() {
        return normalListEndsAt;
    }

    public void setNormalListEndsAt(Integer normalListEndsAt) {
        this.normalListEndsAt = normalListEndsAt;
    }

    public BuyResult withNormalListEndsAt(Integer normalListEndsAt) {
        this.normalListEndsAt = normalListEndsAt;
        return this;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public BuyResult withUpdated(String updated) {
        this.updated = updated;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BuyResult withBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public List<Object> getCorrections() {
        return corrections;
    }

    public void setCorrections(List<Object> corrections) {
        this.corrections = corrections;
    }

    public BuyResult withCorrections(List<Object> corrections) {
        this.corrections = corrections;
        return this;
    }

}
