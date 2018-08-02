package com.company.modals;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String id;
    private int highscore;
    private int game;

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public long getNumericId() {
        return Long.valueOf(id);
    }

}
