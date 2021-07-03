package edu.citytech.cst.s23826271.firstdynamicweb.alphabets;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.AlphabetsBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Alphabet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Alphabets test")
public class T1_ABC {

    @DisplayName("ABC size tes")
    @Test
    void T1(){
        int expected = 26;
        int actual = AlphabetsBO.getAlphabetsCaps().size();
        assertEquals(expected, actual);
    }

    @DisplayName("ABC size tes")
    @Test
    void T2(){
        List<Alphabet> list = AlphabetsBO.getAlphabetsCaps();
        char expected = 'Z';
        int actual = list.get(25).getLetter();
        assertEquals(expected, actual);
    }

    @DisplayName("is 'a' a vowel?")
    @Test
    void T3(){
        char ch= 'a';
        boolean expected = true;
        boolean actual = AlphabetsBO.isVowel(ch);
        assertEquals(expected, actual);
    }

}
