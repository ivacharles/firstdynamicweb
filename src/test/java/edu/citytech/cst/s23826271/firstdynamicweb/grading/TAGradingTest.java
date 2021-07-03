package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GradingPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Test for A ")
public class TAGradingTest {

    @DisplayName("A Test with 94")
    @Test
    void T1(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(94f);
        String expected = "A";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected,actual);
    }
    @DisplayName("A- Test with 88")
    @Test
    void T2(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(92f);
        String expected = "A-";
        String actual = gradingPolicy.getGrade();
        assertEquals(expected,actual);
    }
    @DisplayName("Not an A Test with 89.9999f")
    @Test
    void T3(){
        GradingPolicy gradingPolicy = GradingBO.getGPA(89.99999f);
        boolean condition = gradingPolicy.getGrade().equals("A");
        assertFalse(condition);
    }

}
