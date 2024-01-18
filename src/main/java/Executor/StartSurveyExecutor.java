package Executor;

import Survey.Survey;

public class StartSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;
    @Override
    public void execute(int option) {
        switch (option) {
            case 0:
                currentSurvey = Survey.createSurvey();
                break;
            case 1:
                Survey.displaySurvey(currentSurvey);
                break;
            case 2:
                Survey.loadSurvey(currentSurvey);
                break;
            case 3:
                Survey.saveSurvey(currentSurvey);
                break;
            case 4:
                Survey.takeSurvey(currentSurvey);
                break;
            case 5:
                Survey.modifySurvey(currentSurvey);
                break;
            case 6:
                System.exit(0);
        }
    }

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
