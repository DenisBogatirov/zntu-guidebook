package ua.edu.zntu.guidebook.pojo;


public class Section {
    private String title;
    private long id;

    public Section(long id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() { return title; }

    public long getId() { return id; }

    public static class Builder {

        private String title;
        private long id;

        public Builder() {

        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setId(long id){
            this.id = id;
            return this;
        }

        public Section build(){
            return new Section(id, title);
        }
    }
}
