package com.spring.curd.mongodb.springmongo.model;

public class Favorites {
    private String artist;
    private String food;

    public Favorites(String artist, String food) {
        this.artist = artist;
        this.food = food;
    }

    public Favorites() {
    }

    public String getArtist() {

        return artist;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "artist='" + artist + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
