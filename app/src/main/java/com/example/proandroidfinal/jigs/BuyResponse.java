package com.example.proandroidfinal.jigs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numBuyResult;
    @SerializedName("last_modified")
    @Expose
    private String lastModified;
    @SerializedName("results")
    @Expose
    private BuyResult results;

    /**
     * No args constructor for use in serialization
     *
     */
    public BuyResponse() {
    }

    /**
     *
     * @param results
     * @param lastModified
     * @param status
     * @param numBuyResult
     * @param copyright
     */
    public BuyResponse(String status, String copyright, Integer numBuyResult, String lastModified, BuyResult results) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.numBuyResult = numBuyResult;
        this.lastModified = lastModified;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BuyResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public BuyResponse withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public Integer getNumBuyResult() {
        return numBuyResult;
    }

    public void setNumBuyResult(Integer numBuyResult) {
        this.numBuyResult = numBuyResult;
    }

    public BuyResponse withNumBuyResult(Integer numBuyResult) {
        this.numBuyResult = numBuyResult;
        return this;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public BuyResponse withLastModified(String lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public BuyResult getBuyResult() {
        return results;
    }

    public void setBuyResult(BuyResult results) {
        this.results = results;
    }

    public BuyResponse withBuyResult(BuyResult results) {
        this.results = results;
        return this;
    }

}

