package Executor;

import Survey.Survey;

public class StartSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;
    @Override
    public void execute(int option) {
        switch (option) {
            case 0:
                Survey.createSurvey();
                break;
            case 1:
                Survey.displaySurvey();
                break;
            case 2:
                Survey.loadSurvey();
                break;
            case 3:
                Survey.saveSurvey(currentSurvey);
                break;
            case 4:
                Survey.takeSurvey();
                break;
            case 5:
                Survey.modifySurvey();
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
