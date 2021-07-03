package edu.citytech.cst.s23826271.firstdynamicweb.numbers;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.AlphabetsBO;
import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.NumberClassBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Alphabet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Numbers test")
public class T1_Numbers {

    @DisplayName("is number contains 8, highlight it, else dont")
    @Test
    void T1() {
        int number = 809;
        String expected = "highlight";
        String actual = "";//NumberClassBO.addHtmlClass(number,8);
        assertEquals(expected, actual);
    }

}