package ua.edu.zntu.guidebook.pojo;


public class Lesson {

    private long id;
    private int startInterval;
    private int endInterval;
    private String number;
    private String time;
    private boolean now = false;

    public Lesson(long id, int startInterval, int endInterval, String number, String time) {
        this.id = id;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
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

    public boolean insideInterval(int time){
        return time > startInterval && time < endInterval;
    }
}
