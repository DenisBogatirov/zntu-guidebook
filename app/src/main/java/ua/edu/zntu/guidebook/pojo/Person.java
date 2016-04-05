package ua.edu.zntu.guidebook.pojo;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import ua.edu.zntu.guidebook.R;

public class Person implements Serializable{
    private String job;
    private String name;
    private String phone;
    private String vk;
    private String additional;

    public Person(String job, String name, String phone, String vk, String additional) {
        this.job = job;
        this.name = name;
        this.phone = phone;
        this.vk = vk;
        this.additional = additional;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getVk() {
        return vk;
    }

    public String getAdditional() {
        return additional;
    }

    public View getPersonView(Context context) {
        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View personView = layoutInflater.inflate(R.layout.person_layout, null);
        TextView txtJob = (TextView) personView.findViewById(R.id.person_job_tv);
        TextView txtName = (TextView) personView.findViewById(R.id.person_name_tv);
        TextView txtPhone = (TextView) personView.findViewById(R.id.person_phone_tv);
        TextView txtVk = (TextView) personView.findViewById(R.id.person_vk_tv);
        TextView txtAdditional = (TextView) personView.findViewById(R.id.person_additional_tv);

        txtJob.setText(job);
        txtName.setText(name);
        txtPhone.setText(phone);
        txtVk.setText(vk);
        txtAdditional.setText(additional);

        return personView;
    }

    @Override
    public String toString() {
        return "Person{" +
                "job='" + job + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", vk='" + vk + '\'' +
                ", additional='" + additional + '\'' +
                '}';
    }

    public static class Builder {

        private String job;
        private String name;
        private String phone;
        private String vk;
        private String additional;

        public Builder() {

        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setVk(String vk) {
            this.vk = vk;
            return this;
        }

        public Builder setAdditional(String additional) {
            this.additional = additional != null ? additional : "";
            return this;
        }

        public Person build() {
            return new Person(job, name, phone, vk, additional);
        }
    }
}
