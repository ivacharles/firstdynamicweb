package edu.citytech.cst.s23826271.firstdynamicweb.grading;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("grading file test")
public class T_gradingFile {

    @DisplayName("test the number of records (grade) in files using business Layer")
    @Test
    void T1() throws IOException {
        int expected = 140;
        int actual = GradingBO.getGrades().size();
        assertEquals(expected, actual);
    }

    @DisplayName("list for letter grade A only")
    @Test
    void T2() throws IOException {
        int anyIndex = 2;
        List<Grade> list = GradingBO.findGradesByLetterGrade("A");
        String  expected = "A";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }

    @DisplayName("list for letter grade B only")
    @Test
    void T3() throws IOException {
        int anyIndex = 2;
        List<Grade> list = GradingBO.findGradesByLetterGrade("B");
        String  expected = "B";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("list for letter grade C only")
    @Test
    void T4() throws IOException {
        int anyIndex = 0;
        List<Grade> list = GradingBO.findGradesByLetterGrade("C");
        String  expected = "C";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("list for letter grade A- only")
    @Test
    void T5() throws IOException {
        int anyIndex = 0;
        List<Grade> list = GradingBO.findGradesByLetterGrade("A-");
        String  expected = "A-";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }
    @DisplayName("list for letter grade B+ only")
    @Test
    void T6() throws IOException {
        int anyIndex = 5;
        List<Grade> list = GradingBO.findGradesByLetterGrade("B+");
        String  expected = "B+";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }

    @DisplayName("list for letter grade D only")
    @Test
    void T7() throws IOException {
        int anyIndex = 0;
        List<Grade> list = GradingBO.findGradesByLetterGrade("D");
        String  expected = "D";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }

    @DisplayName("list for letter grade F only")
    @Test
    void T8() throws IOException {
        int anyIndex = 0;
        List<Grade> list = GradingBO.findGradesByLetterGrade("F");
        String  expected = "F";
        String actual = list.get(anyIndex).getLetterGrade();
        assertEquals(expected, actual);
    }

}
