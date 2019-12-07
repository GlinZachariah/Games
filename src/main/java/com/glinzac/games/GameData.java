package com.glinzac.games;

public class GameData {
    private String title;
    private String platform;
    private Double score;
    private String genre;
    private char editors_choice;

    public GameData(){

    }

    public GameData(String title, String platform, Double score, String genre, char editors_choice) {
        this.title = title;
        this.platform = platform;
        this.score = score;
        this.genre = genre;
        this.editors_choice = editors_choice;
    }

    public String getTitle() {
        return title;
    }

    public String getPlatform() {
        return platform;
    }

    public Double getScore() {
        return score;
    }

    public String getGenre() {
        return genre;
    }

    public char getEditors_choice() {
        return editors_choice;
    }
}
