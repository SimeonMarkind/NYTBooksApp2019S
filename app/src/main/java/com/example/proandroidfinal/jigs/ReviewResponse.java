
package com.example.proandroidfinal.jigs;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewResponse {

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
    private List<Result> results = null;

    /**
     * No args constructor for use in serialization
     */
    public ReviewResponse() {
    }

    /**
     * @param results
     * @param status
     * @param numResults
     * @param copyright
     */
    public ReviewResponse(String status, String copyright, Integer numResults, List<Result> results) {
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

    public ReviewResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public ReviewResponse withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public ReviewResponse withNumResults(Integer numResults) {
        this.numResults = numResults;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public ReviewResponse withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}
