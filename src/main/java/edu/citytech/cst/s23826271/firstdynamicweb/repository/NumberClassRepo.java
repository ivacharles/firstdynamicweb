package edu.citytech.cst.s23826271.firstdynamicweb.repository;

import edu.citytech.cst.s23826271.firstdynamicweb.model.NumberMod;

import java.util.ArrayList;
import java.util.List;

public class NumberClassRepo {

    public static List<NumberMod> getNumbers(int countBY){
        List<NumberMod> list = new ArrayList<>();
        if(countBY >= 20) {
            for (int i = 0; i <= 1000; i += countBY) {
                list.add(new NumberMod(i, "n123-100"));
            }
        }else {
            for (int i = 0; i <= 1000; i += countBY) {
                list.add(new NumberMod(i, "n123-001"));
            }
        }
        return list;
    }
}
