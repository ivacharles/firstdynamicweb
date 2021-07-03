package edu.citytech.cst.s23826271.firstdynamicweb.salary;

import com.jbbwebsolutions.helper.EnvironmentUtility;
import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.SalaryBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for file ")
public class T_FileTest {

    @DisplayName("clean jdbc derby database")
    @Test
    void T0(){

    }
    @DisplayName("is file exist")
    @Test
    void T1(){
        String expected = "C:\\summer2021\\data\\Salaries.csv";
        String actual =EnvironmentUtility.get("CST_4713_DATA")+"Salaries.csv";
        System.out.println(EnvironmentUtility.get("CST_4713_DATA"));
        assertEquals(expected,actual);
    }

    @DisplayName("show the number of data from file")
    @Test
    void T2() throws IOException {
        int expected = 289;
        int actual = SalaryBO.getSalariesFromFile().size();
        SalaryBO.getSalariesFromFile().forEach(System.out::println);
        assertEquals(expected,actual);
    }

    @DisplayName("add Salary Data to derby")
    @Test
    void T3() throws IOException, SQLException {
        boolean expected = true;
        boolean actual = SalaryBO.addSalaryList2Derby();
        assertEquals(expected,actual);
    }

    @DisplayName("show the number of data from Derby")
    @Test
    void T4() throws IOException, SQLException {
        int expected = 289;
        int actual = SalaryBO.getSalariesFromDerby().size();
        assertEquals(expected,actual);
    }


}
