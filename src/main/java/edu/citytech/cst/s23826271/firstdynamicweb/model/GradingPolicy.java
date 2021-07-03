package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class GradingPolicy {

    private String definition;
    private String grade;
    private float score;

    public GradingPolicy() {
        this.definition ="Below 60";
        this.grade ="F";
        this.score = 0f;
    }

    public GradingPolicy(String definition, String grade, float score) {
        this.definition = definition;
        this.grade = grade;
        this.score = score;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GradingPolicy{" +
                "definition='" + definition + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
