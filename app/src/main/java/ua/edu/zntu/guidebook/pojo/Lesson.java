package ua.edu.zntu.guidebook.pojo;


public class Lesson {

    private long id;
    private String number;
    private String time;
    private boolean now = false;

    public Lesson(long id, String number, String time) {
        this.id = id;
        this.number = number;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }

    public boolean isNow() {
        return now;
    }

    public void setNow(boolean now) {
        this.now = now;
    }
}
