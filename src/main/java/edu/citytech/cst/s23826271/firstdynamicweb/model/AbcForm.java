package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class AbcForm {
    private String displayMode = "all";
    private String message;


    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
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
