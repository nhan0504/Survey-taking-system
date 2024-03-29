package Question;

import Questionaire.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Essay extends Question{
    int maxCharacter = 200;
    public Essay(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question + " (Max " + maxCharacter + " char)");
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return answer.length() <= maxCharacter;
    }

    @Override
    public void tabulate(HashMap<String, Integer> map) {
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    @Override
    public void getGrade(HashSet<String> set, Test.Grade grade) {
        grade.setTotalGrade(grade.getTotalGrade() - grade.getPointEach());
        grade.setTotalGradable(grade.getTotalGradable()- grade.getPointEach());
    }
}
