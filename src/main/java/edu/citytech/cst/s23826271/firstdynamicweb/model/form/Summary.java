package edu.citytech.cst.s23826271.firstdynamicweb.model.form;

public class Summary {

    private Long count;
    private float average;
    private float max;
    private float min;
    private float sum;
    private float avgGTh90 ;
    private float avgLth70 ;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getAvgGTh90() {
        return avgGTh90;
    }

    public void setAvgGTh90(float avgGTh90) {
        this.avgGTh90 = avgGTh90;
    }

    public float getAvgLth70() {
        return avgLth70;
    }

    public void setAvgLth70(float avgLth70) {
        this.avgLth70 = avgLth70;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "count=" + count +
                ", average=" + average +
                ", max=" + max +
                ", min=" + min +
                ", avgGTh90=" + avgGTh90 +
                ", avgLth70=" + avgLth70 +
                '}';
    }
}
