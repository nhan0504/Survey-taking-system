package Executor;

import Survey.Survey;

public class CreateSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;

    public CreateSurveyExecutor(Survey currentSurvey) {
        this.currentSurvey = currentSurvey;
    }
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                Survey.addTF(currentSurvey);
                return true;
            case 1:
                Survey.addMultipleChoice(currentSurvey);
                return true;
            case 2:
                Survey.addShortAnswer(currentSurvey);
                return true;
            case 3:
                Survey.addEssay(currentSurvey);
                return true;
            case 4:
                Survey.addDate(currentSurvey);
                return true;
            case 5:
                Survey.addMatching(currentSurvey);
                return true;
        }
        return false;
    }

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
