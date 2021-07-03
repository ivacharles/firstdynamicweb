package edu.citytech.cst.s23826271.firstdynamicweb.model;

public class Salary {
    private String id;
    private float salary;
    private String statusCode;
    private float effectiveTaxRate;
    private float tax2Pay;
    private String htmlHighlightClass;

    public Salary(String id, float salary, String statusCode) {
        this.id = id;
        this.salary = salary;
        this.statusCode = statusCode;
    }

    public Salary() {
    }

    public float getEffectiveTaxRate() {
        return effectiveTaxRate;
    }

    public void setEffectiveTaxRate(float effectiveTaxRate) {
        this.effectiveTaxRate = effectiveTaxRate;
    }

    public float getTax2Pay() {
        return tax2Pay;
    }

    public void setTax2Pay(float tax2Pay) {
        this.tax2Pay = tax2Pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", salary=" + salary +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }

    public void setHtmlHighlightClass(String htmlHighlightClass) {
        this.htmlHighlightClass = htmlHighlightClass;
    }

    public String getHtmlHighlightClass() {
        return htmlHighlightClass;
    }
}
