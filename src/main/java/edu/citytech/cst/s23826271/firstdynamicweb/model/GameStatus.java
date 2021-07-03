package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class GameStatus {
    private int p1;
    private int p2;
    private int p3;

    private char whoWon = ' ';

    public GameStatus(int [] moves) {
        this.p1 = moves[0];
        this.p2 = moves[1];
        this.p3 = moves[2];
    }

    public GameStatus() { }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public char getWhoWon() {
        return whoWon;
    }

    public void setWhoWon(char whoWon) {
        this.whoWon = whoWon;
    }

    @Override
    public String toString() {
        return "GameStatus{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", whoWon=" + whoWon +
                '}';
    }
}
