package com.example.boardgames;

public class Game {
    String name;
    Integer minPlayerNum;
    Integer maxPlayerNum;
    Integer gameLength;
    String category;
    String difficulty;

    public Game(String name, Integer minPlayerNum, Integer maxPlayerNum, Integer gameLength, String category, String difficulty) {
        this.name = name;
        this.minPlayerNum = minPlayerNum;
        this.maxPlayerNum = maxPlayerNum;
        this.gameLength = gameLength;
        this.category = category;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return '\"' + name + '\"' +
                ", " + category +
                ", " + difficulty +
                ", for " + minPlayerNum + "-" + maxPlayerNum + " players" +
                " and for " + gameLength + " minutes";
    }
}
