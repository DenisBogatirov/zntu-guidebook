package ua.edu.zntu.guidebook.dto;

import android.graphics.Bitmap;

public class NewsDTO {

    private String title;
    private String text;
    private Bitmap img;

    public NewsDTO(String title, String text, Bitmap img) {
        this.title = title;
        this.text = text;
        this.img = img;
    }

    public NewsDTO(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public NewsDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
