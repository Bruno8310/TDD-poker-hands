package com.example.domain;

public class Poker {

    private Integer id;
    private Character color;

    public Poker(Integer id, Character color) {
        this.id = id;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public Character getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "id=" + id +
                ", color=" + color +
                '}';
    }
}
