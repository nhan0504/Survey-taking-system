package Executor;

import Survey.Survey;

public class CreateSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;

    public CreateSurveyExecutor(Survey currentSurvey) {
        this.currentSurvey = currentSurvey;
    }
    @Override
    public void execute(int option) {
        switch (option) {
            case 0:
                Survey.addTF(currentSurvey);
                break;
            case 1:
                Survey.addMultipleChoice(currentSurvey);
                break;
            case 2:
                Survey.addShortAnswer(currentSurvey);
                break;
            case 3:
                Survey.addEssay(currentSurvey);
                break;
            case 4:
                Survey.addDate(currentSurvey);
                break;
            case 5:
                Survey.addMatching(currentSurvey);
                break;
            case 6:
                System.out.println("Supposed to go back");
                System.exit(0);
        }
    }

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
