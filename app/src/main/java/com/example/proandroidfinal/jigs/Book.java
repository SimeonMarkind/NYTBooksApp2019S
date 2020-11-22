package com.example.proandroidfinal.jigs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("rank_last_week")
    @Expose
    private Integer rankLastWeek;
    @SerializedName("weeks_on_list")
    @Expose
    private Integer weeksOnList;
    @SerializedName("asterisk")
    @Expose
    private Integer asterisk;
    @SerializedName("dagger")
    @Expose
    private Integer dagger;
    @SerializedName("primary_isbn10")
    @Expose
    private String primaryIsbn10;
    @SerializedName("primary_isbn13")
    @Expose
    private String primaryIsbn13;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("contributor")
    @Expose
    private String contributor;
    @SerializedName("contributor_note")
    @Expose
    private String contributorNote;
    @SerializedName("book_image")
    @Expose
    private String bookImage;
    @SerializedName("book_image_width")
    @Expose
    private Integer bookImageWidth;
    @SerializedName("book_image_height")
    @Expose
    private Integer bookImageHeight;
    @SerializedName("amazon_product_url")
    @Expose
    private String amazonProductUrl;
    @SerializedName("age_group")
    @Expose
    private String ageGroup;
    @SerializedName("book_review_link")
    @Expose
    private String bookReviewLink;
    @SerializedName("first_chapter_link")
    @Expose
    private String firstChapterLink;
    @SerializedName("sunday_review_link")
    @Expose
    private String sundayReviewLink;
    @SerializedName("article_chapter_link")
    @Expose
    private String articleChapterLink;
    @SerializedName("isbns")
    @Expose
    private List<Isbn> isbns = null;
    @SerializedName("buy_links")
    @Expose
    private List<BuyLink> buyLinks = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Book() {
    }

    /**
     *
     * @param isbns
     * @param bookReviewLink
     * @param amazonProductUrl
     * @param rankLastWeek
     * @param weeksOnList
     * @param asterisk
     * @param articleChapterLink
     * @param bookImageWidth
     * @param dagger
     * @param publisher
     * @param buyLinks
     * @param author
     * @param contributorNote
     * @param rank
     * @param title
     * @param price
     * @param contributor
     * @param primaryIsbn13
     * @param description
     * @param sundayReviewLink
     * @param firstChapterLink
     * @param bookImage
     * @param primaryIsbn10
     * @param bookImageHeight
     * @param ageGroup
     */
    public Book(Integer rank, Integer rankLastWeek, Integer weeksOnList, Integer asterisk, Integer dagger, String primaryIsbn10, String primaryIsbn13, String publisher, String description, Integer price, String title, String author, String contributor, String contributorNote, String bookImage, Integer bookImageWidth, Integer bookImageHeight, String amazonProductUrl, String ageGroup, String bookReviewLink, String firstChapterLink, String sundayReviewLink, String articleChapterLink, List<Isbn> isbns, List<BuyLink> buyLinks) {
        super();
        this.rank = rank;
        this.rankLastWeek = rankLastWeek;
        this.weeksOnList = weeksOnList;
        this.asterisk = asterisk;
        this.dagger = dagger;
        this.primaryIsbn10 = primaryIsbn10;
        this.primaryIsbn13 = primaryIsbn13;
        this.publisher = publisher;
        this.description = description;
        this.price = price;
        this.title = title;
        this.author = author;
        this.contributor = contributor;
        this.contributorNote = contributorNote;
        this.bookImage = bookImage;
        this.bookImageWidth = bookImageWidth;
        this.bookImageHeight = bookImageHeight;
        this.amazonProductUrl = amazonProductUrl;
        this.ageGroup = ageGroup;
        this.bookReviewLink = bookReviewLink;
        this.firstChapterLink = firstChapterLink;
        this.sundayReviewLink = sundayReviewLink;
        this.articleChapterLink = articleChapterLink;
        this.isbns = isbns;
        this.buyLinks = buyLinks;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Book withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public Integer getRankLastWeek() {
        return rankLastWeek;
    }

    public void setRankLastWeek(Integer rankLastWeek) {
        this.rankLastWeek = rankLastWeek;
    }

    public Book withRankLastWeek(Integer rankLastWeek) {
        this.rankLastWeek = rankLastWeek;
        return this;
    }

    public Integer getWeeksOnList() {
        return weeksOnList;
    }

    public void setWeeksOnList(Integer weeksOnList) {
        this.weeksOnList = weeksOnList;
    }

    public Book withWeeksOnList(Integer weeksOnList) {
        this.weeksOnList = weeksOnList;
        return this;
    }

    public Integer getAsterisk() {
        return asterisk;
    }

    public void setAsterisk(Integer asterisk) {
        this.asterisk = asterisk;
    }

    public Book withAsterisk(Integer asterisk) {
        this.asterisk = asterisk;
        return this;
    }

    public Integer getDagger() {
        return dagger;
    }

    public void setDagger(Integer dagger) {
        this.dagger = dagger;
    }

    public Book withDagger(Integer dagger) {
        this.dagger = dagger;
        return this;
    }

    public String getPrimaryIsbn10() {
        return primaryIsbn10;
    }

    public void setPrimaryIsbn10(String primaryIsbn10) {
        this.primaryIsbn10 = primaryIsbn10;
    }

    public Book withPrimaryIsbn10(String primaryIsbn10) {
        this.primaryIsbn10 = primaryIsbn10;
        return this;
    }

    public String getPrimaryIsbn13() {
        return primaryIsbn13;
    }

    public void setPrimaryIsbn13(String primaryIsbn13) {
        this.primaryIsbn13 = primaryIsbn13;
    }

    public Book withPrimaryIsbn13(String primaryIsbn13) {
        this.primaryIsbn13 = primaryIsbn13;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book withDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Book withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book withAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public Book withContributor(String contributor) {
        this.contributor = contributor;
        return this;
    }

    public String getContributorNote() {
        return contributorNote;
    }

    public void setContributorNote(String contributorNote) {
        this.contributorNote = contributorNote;
    }

    public Book withContributorNote(String contributorNote) {
        this.contributorNote = contributorNote;
        return this;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Book withBookImage(String bookImage) {
        this.bookImage = bookImage;
        return this;
    }

    public Integer getBookImageWidth() {
        return bookImageWidth;
    }

    public void setBookImageWidth(Integer bookImageWidth) {
        this.bookImageWidth = bookImageWidth;
    }

    public Book withBookImageWidth(Integer bookImageWidth) {
        this.bookImageWidth = bookImageWidth;
        return this;
    }

    public Integer getBookImageHeight() {
        return bookImageHeight;
    }

    public void setBookImageHeight(Integer bookImageHeight) {
        this.bookImageHeight = bookImageHeight;
    }

    public Book withBookImageHeight(Integer bookImageHeight) {
        this.bookImageHeight = bookImageHeight;
        return this;
    }

    public String getAmazonProductUrl() {
        return amazonProductUrl;
    }

    public void setAmazonProductUrl(String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
    }

    public Book withAmazonProductUrl(String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
        return this;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Book withAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
        return this;
    }

    public String getBookReviewLink() {
        return bookReviewLink;
    }

    public void setBookReviewLink(String bookReviewLink) {
        this.bookReviewLink = bookReviewLink;
    }

    public Book withBookReviewLink(String bookReviewLink) {
        this.bookReviewLink = bookReviewLink;
        return this;
    }

    public String getFirstChapterLink() {
        return firstChapterLink;
    }

    public void setFirstChapterLink(String firstChapterLink) {
        this.firstChapterLink = firstChapterLink;
    }

    public Book withFirstChapterLink(String firstChapterLink) {
        this.firstChapterLink = firstChapterLink;
        return this;
    }

    public String getSundayReviewLink() {
        return sundayReviewLink;
    }

    public void setSundayReviewLink(String sundayReviewLink) {
        this.sundayReviewLink = sundayReviewLink;
    }

    public Book withSundayReviewLink(String sundayReviewLink) {
        this.sundayReviewLink = sundayReviewLink;
        return this;
    }

    public String getArticleChapterLink() {
        return articleChapterLink;
    }

    public void setArticleChapterLink(String articleChapterLink) {
        this.articleChapterLink = articleChapterLink;
    }

    public Book withArticleChapterLink(String articleChapterLink) {
        this.articleChapterLink = articleChapterLink;
        return this;
    }

    public List<Isbn> getIsbns() {
        return isbns;
    }

    public void setIsbns(List<Isbn> isbns) {
        this.isbns = isbns;
    }

    public Book withIsbns(List<Isbn> isbns) {
        this.isbns = isbns;
        return this;
    }

    public List<BuyLink> getBuyLinks() {
        return buyLinks;
    }

    public void setBuyLinks(List<BuyLink> buyLinks) {
        this.buyLinks = buyLinks;
    }

    public Book withBuyLinks(List<BuyLink> buyLinks) {
        this.buyLinks = buyLinks;
        return this;
    }

}
