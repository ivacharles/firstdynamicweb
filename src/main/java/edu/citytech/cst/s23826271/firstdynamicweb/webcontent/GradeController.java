package edu.citytech.cst.s23826271.firstdynamicweb.webcontent;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.GradingBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Grade;
import edu.citytech.cst.s23826271.firstdynamicweb.model.form.Summary;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;


@Controller
public class GradeController {

    @GetMapping({"/grades" , "/grades/{letterGrade}"})
    public String getGradesByLetter(@PathVariable(name = "letterGrade", required = false) String letterGrade, Model model) throws IOException {
        letterGrade = letterGrade == null ?"all":letterGrade;

        List<Grade> list = GradingBO.findGradesByLetterGrade(letterGrade);
        Summary summary = GradingBO.getSummary4List(list);

        model.addAttribute("grades", list);
        model.addAttribute("summary", summary);
        String lGrade = "Grading Report for "+letterGrade;
        model.addAttribute("lGrade", lGrade);

        System.out.println(summary);
        return "gradingReport";
    }



}
