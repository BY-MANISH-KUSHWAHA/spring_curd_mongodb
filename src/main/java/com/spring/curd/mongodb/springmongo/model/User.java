package com.spring.curd.mongodb.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

// using for database communicating
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private int age;
    private List<Integer> finished;
    private List<String> badges;

    private String privileges;
    private Phone phone;

    private Favorites favorites;

    private List<Points> points;

    public User(){}

    public User(String id, String name, int age, List<Integer> finished, List<String> badges, String privileges, Phone phone, Favorites favorites, List<Points> points) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.finished = finished;
        this.badges = badges;
        this.privileges = privileges;
        this.phone = phone;
        this.favorites = favorites;
        this.points = points;
    }

    public String getPrivileges() {
        return privileges;
    }

    public Favorites getFavorites() {
        return favorites;
    }

    public void setFavorites(Favorites favorites) {
        this.favorites = favorites;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getFinished() {
        return finished;
    }

    public void setFinished(List<Integer> finished) {
        this.finished = finished;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", finished=" + finished +
                ", badges=" + badges +
                ", privileges='" + privileges + '\'' +
                ", phone=" + phone +
                ", favorites=" + favorites +
                ", points=" + points +
                '}';
    }
}
