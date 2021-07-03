package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GradingPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Test for D ")
public class TDGradingTest {

    @DisplayName("D Test with 74")
    @Test
    void T1(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(74f);
        String expected = "D";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected,actual);
    }

    @DisplayName("Not an D Test with 89.9999f")
    @Test
    void T3(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(89.99999f);
        boolean condition = gradingPolicy.getGrade().equals("D");
        assertFalse(condition);
    }

}
