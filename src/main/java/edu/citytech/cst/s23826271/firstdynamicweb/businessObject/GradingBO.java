package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import edu.citytech.cst.s23826271.firstdynamicweb.model.Grade;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GradingPolicy;
import edu.citytech.cst.s23826271.firstdynamicweb.model.form.Summary;
import edu.citytech.cst.s23826271.firstdynamicweb.repository.GradeRepo;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GradingBO {
    public static GradingPolicy getGPA(float score) {
        GradingPolicy gradingPolicy = new GradingPolicy();

        if(score >= 93 && score <= 100)
            gradingPolicy = new GradingPolicy("93-100%", "A",4.0f);
        else if(score >= 90 && score < 93)
            gradingPolicy = new GradingPolicy("90-92.9%", "A-",3.7f);

        else if(score >= 87 && score < 90)
            gradingPolicy = new GradingPolicy("87-89.9%", "B+",3.3f);
        else if(score >= 83 && score < 87)
            gradingPolicy = new GradingPolicy("83-86.9%", "B",3.0f);
        else if(score >= 80 && score < 83)
            gradingPolicy = new GradingPolicy("80-82.9%", "B-",2.7f);

        else if(score >= 77 && score < 80)
            gradingPolicy = new GradingPolicy("77-79.9%", "C+",2.3f);
        else if(score >= 75 && score < 77)
            gradingPolicy = new GradingPolicy("75-76.9%", "C",2.0f);

        else if(score >= 60 && score < 75)
            gradingPolicy = new GradingPolicy("60-74.9%", "D",1.0f);

        return gradingPolicy;
    }

    public static List<Grade> getGrades() throws IOException {
        List<Grade> list = GradeRepo.getGrades();
        return list.stream().map(GradingBO::map2Grade).collect(Collectors.toList());
    }

    private static Grade map2Grade(Grade grade) {
        float [] scores = grade.getScores();
        float total =0f;
        for (float score : scores) {
            total += score;
        }
        float avgScore = total/scores.length;
        GradingPolicy gradingPolicy = getGPA(avgScore);

        grade.setLetterGrade(gradingPolicy.getGrade());
        grade.setGpa(gradingPolicy.getScore());
        grade.setAvgScore(avgScore);
        return grade;
    }

    public static List<Grade> findGradesByLetterGrade(String... letterGrades) throws IOException {
        List<Grade> list = getGrades();

        Predicate<Grade> predicate = e -> true;

        if(letterGrades.length > 0 && !letterGrades[0].equals("all"))
            predicate = e -> e.getLetterGrade().equals(letterGrades[0]);

        return list.stream().filter(predicate).peek(System.out::println).collect(Collectors.toList());
    }

    public static Summary getSummary4List(List<Grade> list) {
        Summary summary = new Summary();
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Grade::getAvgScore));

        summary.setCount(statistics.getCount());
        summary.setAverage((float) statistics.getAverage());
        summary.setMax((float) statistics.getMax());
        summary.setMin((float) statistics.getMin());
        summary.setSum((float) statistics.getSum());
        summary.setAvgGTh90((float) list.stream().filter(g -> g.getAvgScore() > 90.0).mapToDouble(Grade::getAvgScore).max().orElse(0.0));
        summary.setAvgLth70((float) list.stream().filter(g -> g.getAvgScore() < 70.0).mapToDouble(Grade::getAvgScore).max().orElse(0.0));

        //summary.setCount((long) list.size());
        //summary.setAverage(list.stream().collect(Collectors.averagingDouble(Grade::getAvgScore)));
        //summary.setMax(list.stream().mapToDouble(Grade::getAvgScore).max().orElseThrow(NoSuchElementException::new));
        //summary.setMin(list.stream().mapToDouble(Grade::getAvgScore).min().orElseThrow(NoSuchElementException::new));
        //System.out.println(statistics );
        return summary;
    }
}
