package edu.citytech.cst.s23826271.firstdynamicweb.webcontent;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.NumberClassBO;
import edu.citytech.cst.s23826271.firstdynamicweb.model.NumberMod;
import edu.citytech.cst.s23826271.firstdynamicweb.model.form.SelectCountByNHighlightForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NumberController {

    @GetMapping("/number123")
    public String getStaticDesign(){
        return "123Design";
    }

    @GetMapping("/numberD123")
    public String getDynamicDesign(@ModelAttribute SelectCountByNHighlightForm selectCountByNHighlightForm, Model model){
        String htmlHighlightSize = "highlight";

        List<NumberMod> list = new ArrayList<>();
        List<NumberMod> numbers = new ArrayList<>();
        switch (selectCountByNHighlightForm.getDisplayCountBy()){
            case 1:
                list = NumberClassBO.getNumbers(1);
                break;
            case 2:
                list = NumberClassBO.getNumbers(2);
                break;
            case 3:
                list = NumberClassBO.getNumbers(3);
                break;
            case 4:
                list = NumberClassBO.getNumbers(4);
                break;
            case 5:
                list = NumberClassBO.getNumbers(5);
                break;
            case 6:
                list = NumberClassBO.getNumbers(6);
                break;
            case 7:
                list = NumberClassBO.getNumbers(7);
                break;
            case 8:
                list = NumberClassBO.getNumbers(8);
                break;
            case 9:
                list = NumberClassBO.getNumbers(9);
                break;
            case 10:
                list = NumberClassBO.getNumbers(10);
                break;
            case 20:
                list = NumberClassBO.getNumbers(20);
                break;
            case 25:
                list = NumberClassBO.getNumbers(25);
                break;
            case 50:
                list = NumberClassBO.getNumbers(50);
                break;
            case 100:
                list = NumberClassBO.getNumbers(100);
                break;
        }

        switch (selectCountByNHighlightForm.getDisplayHighlight()) {
            case "none":
                numbers = list;
                break;
            case "even":
                numbers = list.stream().map(NumberClassBO::addHtmlClass2AllEvenNumber).collect(Collectors.toList());
                break;
            case "odd":
                numbers = list.stream().map(NumberClassBO::addHtmlClass2AllOddNumber).collect(Collectors.toList());
                break;
            case "every.5":
                numbers = NumberClassBO.addHtmlClass2Every5Number(list);
                break;
            case "every.10":
                numbers = NumberClassBO.addHtmlClass2Every10Number(list);
                break;
            case "contains.8":
                numbers = list.stream().map(NumberClassBO::addHtmlClass2NumberContain8).collect(Collectors.toList());
                break;
        }

        model.addAttribute("numbers", numbers);
        model.addAttribute("htmlHighlightSize", htmlHighlightSize);
        model.addAttribute("selectCountByNHighlightForm", selectCountByNHighlightForm);

        return "123DynamicDesign";
    }

}
