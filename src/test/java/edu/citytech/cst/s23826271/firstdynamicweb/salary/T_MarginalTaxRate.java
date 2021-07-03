package edu.citytech.cst.s23826271.firstdynamicweb.salary;


import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.SalaryBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Salary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for file ")
public class T_MarginalTaxRate {


    @DisplayName("Marginal Tax Rate Test for A single person making $150,000")
    @Test
    void T1(){
        Salary s = new Salary("CH-1024", 5782, "HH");
        float expected = .1f;
        float actual = SalaryBO.getEffectiveTaxRateAndTax2Pay(s).getEffectiveTaxRate();
        assertEquals(expected,actual);
    }

    @DisplayName("Marginal Tax Rate Test for A single person making $299,099")
    @Test
    void T2(){
        Salary s = new Salary("QT-1511", 299099, "MFJ");
        float expected = 0.20001993f;
        float actual = SalaryBO.getEffectiveTaxRateAndTax2Pay(s).getEffectiveTaxRate();
        assertEquals(expected,actual);
    }

    @DisplayName("filtered list for Single only")
    @Test
    void T3() throws SQLException, IOException {
        int expected = 102;
        int actual = SalaryBO.getTaxableList4SingleTaxpayer().size();
        SalaryBO.getTaxableList4SingleTaxpayer().forEach(System.out::println);
        assertEquals(expected,actual);
    }

    @DisplayName("filtered list for MFJ only")
    @Test
    void T4() throws SQLException, IOException {
        int expected = 98;
        int actual = SalaryBO.getTaxableList4MFJTaxpayer().size();
        SalaryBO.getTaxableList4MFJTaxpayer().forEach(System.out::println);
        assertEquals(expected,actual);
    }

    @DisplayName("filtered list for HH only")
    @Test
    void T5() throws SQLException, IOException {
        int expected = 89;
        int actual = SalaryBO.getTaxableList4HHTaxpayer().size();
        SalaryBO.getTaxableList4HHTaxpayer().forEach(System.out::println);
        assertEquals(expected,actual);
    }
}
