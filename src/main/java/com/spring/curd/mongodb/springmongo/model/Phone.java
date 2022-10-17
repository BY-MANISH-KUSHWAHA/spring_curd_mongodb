package com.spring.curd.mongodb.springmongo.model;

public class Phone {
    private String personal;
    private String work;
    private String ext;

    public Phone() {
    }

    public Phone(String personal, String work, String ext) {
        this.personal = personal;
        this.work = work;
        this.ext = ext;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "personal='" + personal + '\'' +
                ", work='" + work + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}
