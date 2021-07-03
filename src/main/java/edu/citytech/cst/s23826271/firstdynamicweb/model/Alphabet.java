package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class Alphabet {

    private char letter;
    private int number;
    private String htmlClass;

    public Alphabet(char letter, int number, String htmlClass) {
        this.letter = letter;
        this.number = number;
        this.htmlClass = htmlClass;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHtmlClass() {
        return htmlClass;
    }

    public void setHtmlClass(String htmlClass) {
        this.htmlClass = htmlClass;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "letter=" + letter +
                ", number=" + number +
                ", htmlClass='" + htmlClass + '\'' +
                '}';
    }
}
