package com.glinzac.games;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    @Column
    private String title;

    @Column
    private String platform;

    @Column
    private Double score;

    @Column
    private String genre;

    @Column
    private char editors_choice;

    public Game(){

    }

    public Game(String title, String platform, Double score, String genre, char editors_choice) {
        this.title = title;
        this.platform = platform;
        this.score = score;
        this.genre = genre;
        this.editors_choice = editors_choice;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public char getEditors_choice() {
        return editors_choice;
    }

    public void setEditors_choice(char editors_choice) {
        this.editors_choice = editors_choice;
    }
}
