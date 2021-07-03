package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import edu.citytech.cst.s23826271.firstdynamicweb.model.Alphabet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AlphabetsBO {

    //functional code
    static private final Function<Character, String> addHtmlClass = ch -> isVowel(ch) ? "vowel" : "consonant";

    public static List<Alphabet> getAlphabetsCaps(){
        List<Alphabet> list = new ArrayList<>();
        int index =0;
        for(char ch='A'; ch<='Z'; ch++){
            list.add(new Alphabet(ch, index++, addHtmlClass.apply(ch) ));
        }

        return list;
    }
    public static List<Alphabet> getReverseAlphabetsCaps(){
        List<Alphabet> list = new ArrayList<>();
        int index =0;
        for(char ch='Z'; ch>='A'; ch--){
            list.add(new Alphabet(ch, index++, addHtmlClass.apply(ch) ));
        }
        return list;
    }

    public static List<Alphabet> getAlphabetsLower(){
        List<Alphabet> list = new ArrayList<>();
        int index =0;
        for(char ch='a'; ch<='z'; ch++){
            list.add(new Alphabet(ch, index++ , addHtmlClass.apply(ch) ));
        }
        return list;
    }
    public static List<Alphabet> getReverseAlphabetsLower(){
        List<Alphabet> list = new ArrayList<>();
        int index =0;
        for(char ch='z'; ch>='a'; ch--){
            list.add(new Alphabet(ch, index++ , addHtmlClass.apply(ch) ));
        }
        return list;
    }

    public static List<Alphabet> getAlphabets(){
        List<Alphabet> list = getAlphabetsCaps();
        list.addAll(getAlphabetsLower());

        return list;
    }
    public static List<Alphabet> getReverseAlphabets(){
        List<Alphabet> list = getReverseAlphabetsCaps();
        list.addAll(getReverseAlphabetsLower());
        return list;
    }

    public static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
