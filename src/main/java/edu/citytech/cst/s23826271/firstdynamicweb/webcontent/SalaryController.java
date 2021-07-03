package edu.citytech.cst.s23826271.firstdynamicweb.webcontent;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.SalaryBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Salary;
import edu.citytech.cst.s23826271.firstdynamicweb.model.form.HighlightSalaryGreatherThanForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SalaryController {

    @GetMapping("/salaries")
    public String getSalaries(@ModelAttribute HighlightSalaryGreatherThanForm highlightForm, Model model)
            throws SQLException, IOException {


        List<Salary> hhList = SalaryBO.getTaxableList4HHTaxpayer().stream().sorted(Comparator.comparing(Salary::getId)).collect(Collectors.toList());
        List<Salary> mfjList = SalaryBO.getTaxableList4MFJTaxpayer().stream().sorted(Comparator.comparing(Salary::getId)).collect(Collectors.toList());
        List<Salary> sList = SalaryBO.getTaxableList4SingleTaxpayer().stream().sorted(Comparator.comparing(Salary::getId)).collect(Collectors.toList());

        switch (highlightForm.getDisplayMode()) {
            case 20 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan20).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan20).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan20).collect(Collectors.toList());
            }
            case 50 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan50).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan50).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan50).collect(Collectors.toList());
            }
            case 100 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan100).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan100).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan100).collect(Collectors.toList());
            }
            case 200 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan200).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan200).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan200).collect(Collectors.toList());
            }
            case 300 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan300).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan300).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan300).collect(Collectors.toList());
            }
            case 500 -> {
                hhList = hhList.stream().map(SalaryBO::addHtmlClass2NumberLessThan500).collect(Collectors.toList());
                mfjList = mfjList.stream().map(SalaryBO::addHtmlClass2NumberLessThan500).collect(Collectors.toList());
                sList = sList.stream().map(SalaryBO::addHtmlClass2NumberLessThan500).collect(Collectors.toList());
            }
        }

        model.addAttribute("sList",sList );
        model.addAttribute("mfjList", mfjList);
        model.addAttribute("hhList", hhList);
        model.addAttribute("highlightForm", highlightForm);

        return "salaries";
    }

    @GetMapping("/salaries-design")
    public String getSalariesDesign(){
        return "salaries-design";
    }
}

/*
567460.0

10% = (9950-0) * 0.1 => 995
12% = 40525 - 9950) *.12 => 3669
22% = 86375 - 40525) * .22 => 10087
24% = (164925 - 86375) * .24 => 18852
32% = (209425 - 164925) * .32 => 14240
35% = (523600 - 209425) * .35 => 109961.25
37% = (567460 - 523600 ) * .37 => 16228.20

tax2pay = 174032.45
taxPercent = 0.3066867268177493
*/