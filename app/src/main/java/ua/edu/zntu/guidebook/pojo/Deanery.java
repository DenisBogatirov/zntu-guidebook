package ua.edu.zntu.guidebook.pojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

import ua.edu.zntu.guidebook.R;

public class Deanery implements Serializable {
    private String title;
    private String address;
    private String room;
    private String phone;
    private String email;

    public Deanery(String title, String address, String room, String phone, String email) {
        this.title = title;
        this.address = address;
        this.room = room;
        this.phone = phone;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public View getView(Context context) {
        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View deaneryView = layoutInflater.inflate(R.layout.deanery_layout, null);

        TextView txtTitle = (TextView) deaneryView.findViewById(R.id.deanery_title);
        TextView txtAddress = (TextView) deaneryView.findViewById(R.id.deanery_address_tv);
        TextView txtRoom = (TextView) deaneryView.findViewById(R.id.deanery_room_tv);
        TextView txtPhone = (TextView) deaneryView.findViewById(R.id.deanery_phone_tv);
        TextView txtEmail = (TextView) deaneryView.findViewById(R.id.deanery_email_tv);


        txtTitle.setText(title);
        txtAddress.setText(address);
        txtRoom.setText(room);
        txtPhone.setText(phone);
        txtEmail.setText(email);

        return deaneryView;
    }

    @Override
    public String toString() {
        return "Deanery{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", room='" + room + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {

        private String title;
        private String address;
        private String room;
        private String phone;
        private String email;

        public Builder() {

        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Deanery build() {
            return new Deanery(title, address, room, phone, email);
        }
    }
}
