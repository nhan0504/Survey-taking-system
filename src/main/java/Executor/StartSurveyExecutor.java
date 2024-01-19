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
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before displaying it");
                } else {
                    Survey.displaySurvey(currentSurvey);
                }
                return true;
            case 2:
                currentSurvey = Survey.loadSurvey();
                return true;
            case 3:
                if (currentSurvey == null) {
                    System.out.println("Must create a survey before saving it");
                } else {
                    Survey.saveSurvey(currentSurvey);
                }
                return true;
            case 4:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before taking it");
                } else {
                    Survey.takeSurvey(currentSurvey);
                }
                return true;
            case 5:
                if (currentSurvey == null) {
                    System.out.println("Must load or create a survey before modifying it");
                } else {
                    Survey.modifySurvey(currentSurvey);
                }
                return true;
        }
        return false;
    }

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
