package Questionaire;

import Executor.CreateSurveyExecutor;
import Menu.CreateSurveyMenu;
import Menu.Menu;
import Question.Question;
import Question.QuestionFactory;
import Utilities.Utilities;

import java.io.*;
import java.util.*;

public class Survey extends Questionaire {
    private Survey() {
        this.name = "";
        this.saveDirectory = "surveys";
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

    public static Survey load() {
        File surveysFolder = new File("surveys");
        String[] allSurveys = surveysFolder.list();

        if (allSurveys.length == 0) {
            System.out.println("No surveys to load");
            return null;
        }

        for (int i = 1; i <= allSurveys.length; i++) {
            System.out.print(i + ". ");
            System.out.println(allSurveys[i - 1]);
        }


        Scanner scanner = new Scanner(System.in);
        String path;

        while(true) {
            System.out.print("Which survey do you want to load? Enter a number: ");
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, allSurveys.length + 1)) {
                int surveyIndex = Integer.parseInt(input) - 1;
                path = "surveys\\" + allSurveys[surveyIndex] + "\\" + allSurveys[surveyIndex] + ".txt";
                break;
            }
        }

        return Utilities.deserialize(path, Survey.class);
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
