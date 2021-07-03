package edu.citytech.cst.s23826271.firstdynamicweb.model.form;

public class SelectCountByNHighlightForm {
    private int displayCountBy  = 20;
    private String displayHighlight = "contains.8";
    private String message;


    public int getDisplayCountBy() {
        return displayCountBy;
    }

    public void setDisplayCountBy(int displayCountBy) {
        this.displayCountBy = displayCountBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDisplayHighlight() {
        return displayHighlight;
    }

    public void setDisplayHighlight(String displayHighlight) {
        this.displayHighlight = displayHighlight;
    }

    @Override
    public String toString() {
        return "AbcForm{" +
                "displayMode='" + displayCountBy + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
