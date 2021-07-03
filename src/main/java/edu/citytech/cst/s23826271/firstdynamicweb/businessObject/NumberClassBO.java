
package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;


import edu.citytech.cst.s23826271.firstdynamicweb.model.NumberMod;
import edu.citytech.cst.s23826271.firstdynamicweb.repository.NumberClassRepo;

import java.util.List;

public class NumberClassBO {

    public static List<NumberMod> getNumbers(int countBY){
        return NumberClassRepo.getNumbers(countBY);
    }

    public static NumberMod addHtmlClass2NumberContain8(NumberMod n) {
        int targetNumber = 8;
        int number = n.getNumber();
        do {
            int digit  = number % 10;
            if (digit == targetNumber) {
                n.setHtmlHighlightClass("highlight");
                break;
            }
            number/=10;
        }while (number != 0);
        return n;
    }

    public static NumberMod addHtmlClass2AllEvenNumber(NumberMod n) {
        int number = n.getNumber();
        if(number % 2 ==0){
            n.setHtmlHighlightClass("highlight");
        }
        return n;
    }

    public static NumberMod addHtmlClass2AllOddNumber(NumberMod n) {
        int number = n.getNumber();
        if(number % 2 !=0){
            n.setHtmlHighlightClass("highlight");
        }
        return n;
    }


    public static List<NumberMod> addHtmlClass2Every10Number(List<NumberMod> list) {
        for (int i = 0; i < list.size(); i+=10) {
            list.get(i).setHtmlHighlightClass("highlight");
        }
        return list;
    }

    public static List<NumberMod> addHtmlClass2Every5Number(List<NumberMod> list) {
        for (int i = 0; i < list.size(); i+=5) {
            list.get(i).setHtmlHighlightClass("highlight");
        }
        return list;
    }
}


