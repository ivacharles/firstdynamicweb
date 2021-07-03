package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import edu.citytech.cst.s23826271.firstdynamicweb.model.NumberMod;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Salary;
import edu.citytech.cst.s23826271.firstdynamicweb.repository.SalaryRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryBO {

    private static final List<Float> brackets = Arrays.asList(.1f, .12f, .22f, .24f, .32f, .35f, .37f);
    private static final List<Float> singleTaxIncome = Arrays.asList(0f, 9950f, 40525f, 86375f, 164925f, 209425f, 523600f);
    private static final List<Float> MFJTaxIncome = Arrays.asList(0f, 19900f, 81050f, 172750f, 329850f, 418850f, 628300f);
    private static final List<Float> HHHTaxIncome = Arrays.asList(0f, 14200f, 54200f, 86350f, 164900f, 209400f, 523600f);

    public static List<Salary> getSalariesFromFile() throws IOException {
        return SalaryRepo.getSalaries();
    }

    public static boolean addSalaryList2Derby() throws IOException, SQLException {
        int count = 0;
        for (Salary s : getSalariesFromFile()) {
            SalaryRepo.insertSalaryIntoDerby(s);
            ++count;
        }
        if (count == 289)
            return true;
        return false;
    }

    public static List<Salary> getSalariesFromDerby() throws IOException, SQLException {
        return SalaryRepo.salaries();
    }

    public static Salary getEffectiveTaxRateAndTax2Pay(Salary s) {
        float eTR;
        float tax2Pay = 0f;
        String userStatus = s.getStatusCode(); //get the taxpayer status
        //get the right taxable list base on user status
        List<Float> taxableList = getTaxableIncomeList(userStatus);
        //find the right bracket index for taxpayer base on salary
        int bracketIndex = getBracket(s.getSalary(), taxableList);

        for (int i = 1; i < bracketIndex; i++) {
            tax2Pay += (taxableList.get(i) - taxableList.get(i - 1)) * brackets.get(i - 1);
            System.out.println((taxableList.get(i)) + " - " + taxableList.get(i - 1) + " = " + tax2Pay);
        }
        tax2Pay += (s.getSalary() - taxableList.get(bracketIndex - 1)) * brackets.get(bracketIndex - 1);
        System.out.println(tax2Pay);

        eTR = tax2Pay / s.getSalary();
        //
        eTR = (float) Math.round(eTR * 100.0f) / 100.0f;
        tax2Pay = (float) Math.round(tax2Pay * 100.0f) / 100.0f;

        s.setEffectiveTaxRate(eTR);
        s.setTax2Pay(tax2Pay);
        return s;
    }

    private static int getBracket(float salary, List<Float> taxableList) {
        int bracketIndex = 0;
        for (int i = 0; i < brackets.size(); i++) {
            if (salary > taxableList.get(i)) {
                ++bracketIndex;
            }
        }
        return bracketIndex;
    }

    private static List<Float> getTaxableIncomeList(String status) {
        List<Float> taxableList = new ArrayList<>();
        //get the status of the taxpayer
        switch (status) {
            case "S":
                taxableList = singleTaxIncome;
                break;
            case "MFJ":
                taxableList = MFJTaxIncome;
                break;
            case "HH":
                taxableList = HHHTaxIncome;
                break;
        }
        return taxableList;
    }

    public static List<Salary> getTaxableList4SingleTaxpayer() throws SQLException, IOException {
        List<Salary> list;
        list = getSalariesFromDerby().stream()
                .filter(s -> s.getStatusCode().equals("S"))
                .map(SalaryBO::getEffectiveTaxRateAndTax2Pay)
                .peek(System.out::println)
                .collect(Collectors.toList());
        return list;
    }

    public static List<Salary> getTaxableList4MFJTaxpayer() throws SQLException, IOException {
        List<Salary> list;
        list = getSalariesFromDerby().stream()
                .filter(s -> s.getStatusCode().equals("MFJ"))
                .peek(System.out::println)
                .map(SalaryBO::getEffectiveTaxRateAndTax2Pay)
                .collect(Collectors.toList());
        return list;
    }

    public static List<Salary> getTaxableList4HHTaxpayer() throws SQLException, IOException {
        List<Salary> list;
        list = getSalariesFromDerby().stream()
                .filter(s -> s.getStatusCode().equals("HH"))
                .map(SalaryBO::getEffectiveTaxRateAndTax2Pay)
                .peek(System.out::println)
                .collect(Collectors.toList());
        return list;
    }

    public static Salary addHtmlClass2NumberLessThan20(Salary s) {
        return checkUp4Range(5000, 20000, s);
    }

    public static Salary addHtmlClass2NumberLessThan50(Salary s) {
        return checkUp4Range(20000, 50000, s);
    }
    public static Salary addHtmlClass2NumberLessThan100(Salary s) {
        return checkUp4Range(50000, 100000, s);
    }

    public static Salary addHtmlClass2NumberLessThan200(Salary s) {
        return checkUp4Range(100000, 200000, s);
    }

    public static Salary addHtmlClass2NumberLessThan300(Salary s) {
        return checkUp4Range(200000, 300000, s);
    }

    public static Salary addHtmlClass2NumberLessThan500(Salary s) {
        return checkUp4Range(300000, 500000, s);
    }

    private static Salary checkUp4Range(int range1, int range2, Salary s){
        if (s.getSalary() > range1 && s.getSalary() < range2) {
            s.setHtmlHighlightClass("highlight");
        }
        return s;
    }
}
