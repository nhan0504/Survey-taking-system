package Executor;

import Questionaire.Survey;

public class StartSurveyExecutor implements Executor {
    public Survey currentSurvey;
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentSurvey = Survey.createSurvey();
                return true;
            case 1:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before displaying");
                }
                currentSurvey.display();
                return true;
            case 2:
                currentSurvey = Survey.loadSurvey();
                return true;
            case 3:
                Survey.saveSurvey(currentSurvey);
                return true;
            case 4:
                Survey.takeSurvey(currentSurvey);
                return true;
            case 5:
                Survey.modifySurvey(currentSurvey);
                return true;
        }
        return false;
    }
}
