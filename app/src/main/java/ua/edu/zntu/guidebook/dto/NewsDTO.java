package ua.edu.zntu.guidebook.dto;

public class NewsDTO {

    private String title;
    private String text;

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
}
