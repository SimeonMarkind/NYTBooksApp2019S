package com.example.proandroidfinal.jigs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListResult {

    @SerializedName("list_name")
    @Expose
    private String listName;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("list_name_encoded")
    @Expose
    private String listNameEncoded;
    @SerializedName("oldest_published_date")
    @Expose
    private String oldestPublishedDate;
    @SerializedName("newest_published_date")
    @Expose
    private String newestPublishedDate;
    @SerializedName("updated")
    @Expose
    private String updated;

    /**
     * No args constructor for use in serialization
     */
    public ListResult() {
    }

    /**
     * @param newestPublishedDate
     * @param listNameEncoded
     * @param listName
     * @param updated
     * @param displayName
     * @param oldestPublishedDate
     */
    public ListResult(String listName, String displayName, String listNameEncoded, String oldestPublishedDate, String newestPublishedDate, String updated) {
        super();
        this.listName = listName;
        this.displayName = displayName;
        this.listNameEncoded = listNameEncoded;
        this.oldestPublishedDate = oldestPublishedDate;
        this.newestPublishedDate = newestPublishedDate;
        this.updated = updated;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public ListResult withListName(String listName) {
        this.listName = listName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ListResult withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getListNameEncoded() {
        return listNameEncoded;
    }

    public void setListNameEncoded(String listNameEncoded) {
        this.listNameEncoded = listNameEncoded;
    }

    public ListResult withListNameEncoded(String listNameEncoded) {
        this.listNameEncoded = listNameEncoded;
        return this;
    }

    public String getOldestPublishedDate() {
        return oldestPublishedDate;
    }

    public void setOldestPublishedDate(String oldestPublishedDate) {
        this.oldestPublishedDate = oldestPublishedDate;
    }

    public ListResult withOldestPublishedDate(String oldestPublishedDate) {
        this.oldestPublishedDate = oldestPublishedDate;
        return this;
    }

    public String getNewestPublishedDate() {
        return newestPublishedDate;
    }

    public void setNewestPublishedDate(String newestPublishedDate) {
        this.newestPublishedDate = newestPublishedDate;
    }

    public ListResult withNewestPublishedDate(String newestPublishedDate) {
        this.newestPublishedDate = newestPublishedDate;
        return this;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public ListResult withUpdated(String updated) {
        this.updated = updated;
        return this;
    }
}
