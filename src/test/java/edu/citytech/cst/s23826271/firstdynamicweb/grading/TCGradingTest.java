package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GradingPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Test for C")
public class TCGradingTest {

    @DisplayName("C+ Test with 78")
    @Test
    void T1(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(78f);
        String expected = "C+";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected,actual);
    }
    @DisplayName("C Test with 76")
    @Test
    void T2(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(76f);
        String expected = "C";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected,actual);
    }
    @DisplayName("Not an C Test with 89.9999f")
    @Test
    void T3(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(89.99999f);
        boolean condition = gradingPolicy.getGrade().equals("C");
        assertFalse(condition);
    }

}
