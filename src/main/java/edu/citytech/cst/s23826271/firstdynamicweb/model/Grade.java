package edu.citytech.cst.s23826271.firstdynamicweb.model;

import java.util.Arrays;

public class Grade {
    private int id;
    private float[] scores;

    private String letterGrade;
    private float gpa;
    private float avgScore;

    public Grade() {
    }

    public Grade(int id, float[] scores) {
        this.id = id;
        this.scores = scores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float[] getScores() {
        return scores;
    }

    public void setScores(float[] scores) {
        this.scores = scores;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", scores=" + Arrays.toString(scores) +
                ", letterGrade='" + letterGrade + '\'' +
                ", gpa=" + gpa +
                ", avgScore=" + avgScore +
                '}';
    }
}