package com.example.domain;

public class Poker {

    private String id;
    private Character color;

    public Poker(String id, Character color) {
        this.id = this.match(id);
        this.color = color;
    }

    private String match(String character) {
        switch (character) {
            case "T":
                return "10";
            case "J":
                return "11";
            case "Q":
                return "12";
            case "K":
                return "13";
            case "A":
                return "14";
            default:
                return character;
        }
    }

    public String getId() {
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
