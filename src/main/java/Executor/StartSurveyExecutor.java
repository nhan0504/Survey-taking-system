package Executor;

import Questionaire.Survey;

public class StartSurveyExecutor implements Executor {
    public Survey currentSurvey;
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentSurvey = Survey.create();
                return true;
            case 1:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before displaying");
                } else {
                    currentSurvey.display();
                }
                return true;
            case 2:
                currentSurvey = Survey.load();
                return true;
            case 3:
                if (currentSurvey == null) {
                    System.out.println("Must create a survey before saving");
                } else {
                    currentSurvey.save();
                }
                return true;
            case 4:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before taking");
                } else {
                    currentSurvey.take();
                }
                return true;
            case 5:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before modifying");
                } else {
                    currentSurvey.modify();
                    currentSurvey.save();
                }
                return true;
            case 6:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before tabulating");
                } else {
                    currentSurvey.tabulate();
                }
                return true;
        }
        return false;
    }
}
