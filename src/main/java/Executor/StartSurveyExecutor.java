package Executor;

import Survey.Survey;

public class StartSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentSurvey = Survey.createSurvey();
                return true;
            case 1:
                Survey.displaySurvey(currentSurvey);
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

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
