package edu.citytech.cst.s23826271.firstdynamicweb.webcontent;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.AlphabetsBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.AbcForm;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Alphabet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ABCController {

    @GetMapping("/abc")
    public String getABC(){
        return "alphabets";
    }

    @GetMapping("/abcd")
    public String getABCDynamic(@ModelAttribute AbcForm abcForm, Model model){
        String abcCssClassName = "abc";

        List<Alphabet> alphabetsList = new ArrayList<>();

        switch (abcForm.getDisplayMode()) {
            case "all":
                alphabetsList = AlphabetsBO.getAlphabets();
                break;
            case "upper":
                alphabetsList = AlphabetsBO.getAlphabetsCaps();
                abcCssClassName = "abc-bigger";
                break;
            case "lower":
                alphabetsList = AlphabetsBO.getAlphabetsLower();
                abcCssClassName = "abc-bigger";
                break;
            case "rAll":
                alphabetsList = AlphabetsBO.getReverseAlphabets();
                break;
            case "rUpper":
                alphabetsList = AlphabetsBO.getReverseAlphabetsCaps();
                abcCssClassName = "abc-bigger";
                break;
            case "rLower":
                alphabetsList = AlphabetsBO.getReverseAlphabetsLower();
                abcCssClassName = "abc-bigger";
                break;
        }

        model.addAttribute("alphabets", alphabetsList);
        model.addAttribute("abcForm", abcForm);
        model.addAttribute("abcCssClassName", abcCssClassName);

        return "alphabets_dynamic";
    }
}
