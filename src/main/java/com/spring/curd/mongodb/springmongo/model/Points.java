package com.spring.curd.mongodb.springmongo.model;

public class Points {
    //      { "points": 85, "bonus": 20 },
    //      { "points": 85, "bonus": 10 }
    private int points;
    private int bonus;

    public Points() {
    }

    public Points(int points, int bonus) {
        this.points = points;
        this.bonus = bonus;
    }

    public int getPoints() {
        return points;
    }

    public int getBonus() {

        return bonus;
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                ", bonus=" + bonus +
                '}';
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
