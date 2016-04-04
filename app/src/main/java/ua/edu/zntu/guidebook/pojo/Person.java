package ua.edu.zntu.guidebook.pojo;

public class Person {
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
