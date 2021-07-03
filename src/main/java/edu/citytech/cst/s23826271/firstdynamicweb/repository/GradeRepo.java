package edu.citytech.cst.s23826271.firstdynamicweb.repository;

import com.jbbwebsolutions.helper.EnvironmentUtility;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Grade;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GradeRepo {

    //this is a map function. It takes a string row and return a model grade, one id and an array of scores
    public static Grade gradeMap(String rowData){
        Grade grade = new Grade();
        String [] dataRow = rowData.split(",");
        float [] scores = new float[dataRow.length-1];

        grade.setId(Integer.parseInt(dataRow[0]));

        for (int i = 1; i < dataRow.length; i++) {
            scores[i-1] = Float.parseFloat(dataRow[i]);
        }

        grade.setScores(scores);
        return grade;
    }

    public static List<Grade> getGrades() throws IOException {
        List<Grade> list = new ArrayList<>();

        Path path = Paths.get(EnvironmentUtility.get("CST_4713_EXAM_DATA"));

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();//skip the first line
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(gradeMap(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
