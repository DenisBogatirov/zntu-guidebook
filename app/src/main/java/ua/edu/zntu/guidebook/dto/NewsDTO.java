package ua.edu.zntu.guidebook.dto;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NewsDTO {

    @SerializedName("newsID")
    @Expose
    private Integer newsID;
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
    @SerializedName("newsImgWidth")
    @Expose
    private Integer newsImgWidth;
    @SerializedName("newsImgHeight")
    @Expose
    private Integer newsImgHeight;

    /**
     *
     * @return
     * The newsID
     */
    public Integer getNewsID() {
        return newsID;
    }

    /**
     *
     * @param newsID
     * The newsID
     */
    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    /**
     *
     * @return
     * The newsDate
     */
    public String getNewsDate() {
        return newsDate;
    }

    /**
     *
     * @param newsDate
     * The newsDate
     */
    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    /**
     *
     * @return
     * The newsTitle
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     *
     * @param newsTitle
     * The newsTitle
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     *
     * @return
     * The newsLitteImg
     */
    public String getNewsLitteImg() {
        return newsLitteImg;
    }

    /**
     *
     * @param newsLitteImg
     * The newsLitteImg
     */
    public void setNewsLitteImg(String newsLitteImg) {
        this.newsLitteImg = newsLitteImg;
    }

    /**
     *
     * @return
     * The newsText
     */
    public String getNewsText() {
        return newsText;
    }

    /**
     *
     * @param newsText
     * The newsText
     */
    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    /**
     *
     * @return
     * The newsImgWidth
     */
    public Integer getNewsImgWidth() {
        return newsImgWidth;
    }

    /**
     *
     * @param newsImgWidth
     * The newsImgWidth
     */
    public void setNewsImgWidth(Integer newsImgWidth) {
        this.newsImgWidth = newsImgWidth;
    }

    /**
     *
     * @return
     * The newsImgHeight
     */
    public Integer getNewsImgHeight() {
        return newsImgHeight;
    }

    /**
     *
     * @param newsImgHeight
     * The newsImgHeight
     */
    public void setNewsImgHeight(Integer newsImgHeight) {
        this.newsImgHeight = newsImgHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof NewsDTO)) { return false; }

        NewsDTO newsDTO = (NewsDTO) o;

        if (!getNewsID().equals(newsDTO.getNewsID())) { return false; }
        if (!getNewsDate().equals(newsDTO.getNewsDate())) { return false; }
        if (!getNewsTitle().equals(newsDTO.getNewsTitle())) { return false; }
        if (!getNewsLitteImg().equals(newsDTO.getNewsLitteImg())) { return false; }
        if (!getNewsText().equals(newsDTO.getNewsText())) { return false; }
        if (!getNewsImgWidth().equals(newsDTO.getNewsImgWidth())) { return false; }
        if (!getNewsImgHeight().equals(newsDTO.getNewsImgHeight())) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getNewsID().hashCode();
        result = 31 * result + getNewsDate().hashCode();
        result = 31 * result + getNewsTitle().hashCode();
        result = 31 * result + getNewsLitteImg().hashCode();
        result = 31 * result + getNewsText().hashCode();
        result = 31 * result + getNewsImgWidth().hashCode();
        result = 31 * result + getNewsImgHeight().hashCode();
        return result;
    }
}

