package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class NumberMod {
    private int number;
    private String htmlSizeClass;
    private String htmlHighlightClass;

    public NumberMod() {}

    public NumberMod(int number) {
        this.number = number;
    }

    public NumberMod(int number, String htmlSizeClass) {
        this.number = number;
        this.htmlSizeClass = htmlSizeClass;
        htmlHighlightClass = "";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHtmlSizeClass() {
        return htmlSizeClass;
    }

    public void setHtmlSizeClass(String htmlSizeClass) {
        this.htmlSizeClass = htmlSizeClass;
    }

    public String getHtmlHighlightClass() {
        return htmlHighlightClass;
    }

    public void setHtmlHighlightClass(String htmlHighlightClass) {
        this.htmlHighlightClass = htmlHighlightClass;
    }

    @Override
    public String toString() {
        return "NumberMod{" +
                "number=" + number +
                ", htmlSizeClass='" + htmlSizeClass + '\'' +
                ", htmlHighlightClass='" + htmlHighlightClass + '\'' +
                '}';
    }
}
