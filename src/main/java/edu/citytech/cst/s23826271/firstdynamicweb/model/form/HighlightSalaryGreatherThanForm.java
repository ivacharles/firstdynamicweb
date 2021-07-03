package edu.citytech.cst.s23826271.firstdynamicweb.model.form;

public class HighlightSalaryGreatherThanForm {
    private int displayMode  = 20;
    private String message;


    public int getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(int displayCountBy) {
        this.displayMode = displayCountBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AbcForm{" +
                "displayMode='" + displayMode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
