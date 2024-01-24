package Questionaire;

import Executor.CreateSurveyExecutor;
import Menu.CreateMenu;
import Menu.Menu;

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
        Menu createMenu = new CreateMenu(new CreateSurveyExecutor(newSurvey));

        while (true) {
            String surveyName = getFileName("survey");

            File folder = new File(saveDirectory + "\\" + surveyName);
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

}
