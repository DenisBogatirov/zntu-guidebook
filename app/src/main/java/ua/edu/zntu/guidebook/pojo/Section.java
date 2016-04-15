package ua.edu.zntu.guidebook.pojo;


import android.content.Context;
import android.view.View;

import java.io.Serializable;
import java.util.LinkedList;

public class Section implements Serializable{
    private long id;
    private String title;
    private LinkedList<Person> persons = new LinkedList<>();
    private LinkedList<Deanery> deaneries = new LinkedList<>();

    public Section(long id, String title, LinkedList<Person> persons, LinkedList<Deanery> deaneries) {
        this.id = id;
        this.title = title;
        this.persons = persons;
        this.deaneries = deaneries;
    }

    public String getTitle() { return title; }

    public long getId() { return id; }

    public LinkedList<Person> getPersons() { return persons; }

    public LinkedList<Deanery> getDeaneries() {
        return deaneries;
    }

    public LinkedList<View> getViews(Context context) {
        LinkedList<View> views = new LinkedList<>();

        for (Deanery obj : deaneries){
            views.add(obj.getView(context));
        }

        for (Person obj : persons){
            views.add(obj.getView(context));
        }

        return views;
    }

    public static class Builder {

        private String title;
        private long id;
        private LinkedList<Person> persons = new LinkedList<>();
        private LinkedList<Deanery> deaneries = new LinkedList<>();

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

        public Builder setDeaneries(LinkedList<Deanery> deaneries) {
            this.deaneries = deaneries;
            return this;
        }

        public Section build() {
            return new Section(id, title, persons, deaneries);
        }
    }
}
