package Questionaire;

import Executor.CreateSurveyExecutor;
import Menu.CreateSurveyMenu;
import Menu.Menu;
import Question.Question;
import Question.QuestionFactory;
import Utilities.Utilities;

import java.io.*;
import java.util.*;

public class Survey extends Questionnaire {
    private static final String saveDirectory = "surveys";
    private Survey() {
        this.name = "";
        this.questions = new ArrayList<>();
    }

    public static Survey create() {
        Survey newSurvey = new Survey();
        Menu createMenu = new CreateSurveyMenu(new CreateSurveyExecutor(newSurvey));

        while (true) {
            String surveyName = getFileName("survey");

            File folder = new File("surveys\\" + surveyName);
            if (!folder.exists()) {
                newSurvey.name = surveyName;
                break;
            } else {
                System.out.println("A survey with this name already exist");
            }
        }

        createMenu.run();

        return newSurvey;
    }

    public void save() {
        this.save(saveDirectory);
    }

    public void take() {
        this.take(saveDirectory);
    }

    public static Survey load() {
        return Questionnaire.load(Survey.class, saveDirectory);
    }

    @Override
    public void tabulate() {

    }


    public static void addTF(Survey currentSurvey) {
        Question question = QuestionFactory.createTrueFalse();
        currentSurvey.questions.add(question);
    }

    public static void addMultipleChoice(Survey currentSurvey) {
        Question question = QuestionFactory.createMultipleChoice();
        currentSurvey.questions.add(question);
    }

    public static void addShortAnswer(Survey currentSurvey) {
        Question question = QuestionFactory.createShortAnswer();
        currentSurvey.questions.add(question);
    }

    public static void addEssay(Survey currentSurvey) {
        Question question = QuestionFactory.createEssay();
        currentSurvey.questions.add(question);
    }

    public static void addDate(Survey currentSurvey) {
        Question question = QuestionFactory.createDate();
        currentSurvey.questions.add(question);
    }

    public static void addMatching(Survey currentSurvey) {
        Question question = QuestionFactory.createMatching();
        currentSurvey.questions.add(question);
    }

}
