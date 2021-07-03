package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import com.jbbwebsolutions.helper.EnvironmentUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for file ")
public class T_FileTest {

    @DisplayName("is file exist")
    @Test
    void T1(){
        String expected = "C:\\Users\\less7\\Downloads\\files\\Students.csv";
        String actual = EnvironmentUtility.get("CST_4713_EXAM_DATA");
        System.out.println(EnvironmentUtility.get("CST_4713_EXAM_DATA"));
        assertEquals(expected,actual);
    }
}
