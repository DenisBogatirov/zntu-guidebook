package ua.edu.zntu.guidebook.pojo;

public class Room {

    private final String title;
    private final String housing;
    private final String floor;
    private final String description;

    public Room(String title, String housing, String floor, String description) {
        this.title = title;
        this.housing = housing;
        this.floor = floor;
        this.description = description;
    }

    public String getTitle() { return title; }

    public String getHousing() { return housing; }

    public String getFloor() { return floor; }

    public String getDescription() { return description; }

    public static class Builder {

        private String title;
        private String housing;
        private String floor;
        private String description;

        public Builder() {

        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setHousing(String housing) {
            this.housing = housing;
            return this;
        }

        public Builder setFloor(String floor) {
            this.floor = floor;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Room build(){
            return new Room(title, housing, floor, description);
        }
    }


}
