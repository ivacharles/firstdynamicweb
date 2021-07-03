package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GradingPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Test for B ")
public class TBGradingTest {

    @DisplayName("B+ Test with 89.999")
    @Test
    void T1() {
        GradingPolicy gradingPolicy = GradingBO.getGPA(89.99999f);
        String expected = "B+";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("B Test with 83.999")
    @Test
    void T2() {
        GradingPolicy gradingPolicy = GradingBO.getGPA(83.99999f);
        String expected = "B";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("B- Test with 83.999")
    @Test
    void T3() {
        GradingPolicy gradingPolicy = GradingBO.getGPA(82.99999f);
        String expected = "B-";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("Not an B Test with 89.9999f")
    @Test
    void T4(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(89.99999f);
        boolean condition = gradingPolicy.getGrade().equals("B");
        assertFalse(condition);
    }
}