package ua.edu.zntu.guidebook.dto;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NewsDTO {

    @SerializedName("newsID")
    @Expose
    private String newsID;
    @SerializedName("newsDate")
    @Expose
    private String newsDate;
    @SerializedName("newsTitle")
    @Expose
    private String newsTitle;
    @SerializedName("newsLitteImg")
    @Expose
    private String newsLitteImg;
    @SerializedName("newsText")
    @Expose
    private String newsText;

    /**
     * @return The newsID
     */
    public String getNewsID() {
        return newsID;
    }

    /**
     * @param newsID The newsID
     */
    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    /**
     * @return The newsDate
     */
    public String getNewsDate() {
        return newsDate;
    }

    /**
     * @param newsDate The newsDate
     */
    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    /**
     * @return The newsTitle
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * @param newsTitle The newsTitle
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * @return The newsLitteImg
     */
    public String getNewsLitteImg() {
        return newsLitteImg;
    }

    /**
     * @param newsLitteImg The newsLitteImg
     */
    public void setNewsLitteImg(String newsLitteImg) {
        this.newsLitteImg = newsLitteImg;
    }

    /**
     * @return The newsText
     */
    public String getNewsText() {
        return newsText;
    }

    /**
     * @param newsText The newsText
     */
    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

}
