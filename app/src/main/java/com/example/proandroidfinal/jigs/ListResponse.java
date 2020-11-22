
package com.example.proandroidfinal.jigs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<ListResult> results = null;

    /**
     * No args constructor for use in serialization
     */
    public ListResponse() {
    }

    /**
     * @param results
     * @param status
     * @param numResults
     * @param copyright
     */
    public ListResponse(String status, String copyright, Integer numResults, List<ListResult> results) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ListResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public ListResponse withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public ListResponse withNumResults(Integer numResults) {
        this.numResults = numResults;
        return this;
    }

    public List<ListResult> getResults() {
        return results;
    }

    public void setResults(List<ListResult> results) {
        this.results = results;
    }

    public ListResponse withResults(List<ListResult> results) {
        this.results = results;
        return this;
    }

}
