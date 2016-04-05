package ua.edu.zntu.guidebook.pojo;


import java.io.Serializable;
import java.util.LinkedList;

public class Section implements Serializable{
    private long id;
    private String title;
    private LinkedList<Person> persons = new LinkedList<>();

    public Section(long id, String title, LinkedList<Person> persons) {
        this.title = title;
        this.id = id;
        this.persons = persons;
    }

    public String getTitle() { return title; }

    public long getId() { return id; }

    public LinkedList<Person> getPersons() { return persons; }

    public static class Builder {

        private String title;
        private long id;
        private LinkedList<Person> persons = new LinkedList<>();

        public Builder() {

        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setPersons(LinkedList<Person> persons) {
            this.persons = persons;
            return this;
        }

        public Section build() {
            return new Section(id, title, persons);
        }
    }
}
