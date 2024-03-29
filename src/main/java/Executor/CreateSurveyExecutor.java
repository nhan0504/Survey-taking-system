package Executor;

import Questionaire.Survey;

public class CreateSurveyExecutor implements Executor {
    public Survey currentSurvey;

    public CreateSurveyExecutor(Survey currentSurvey) {
        this.currentSurvey = currentSurvey;
    }
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentSurvey.addTF();
                return true;
            case 1:
                currentSurvey.addMultipleChoice();
                return true;
            case 2:
                currentSurvey.addShortAnswer();
                return true;
            case 3:
                currentSurvey.addEssay();
                return true;
            case 4:
                currentSurvey.addDate();
                return true;
            case 5:
                currentSurvey.addMatching();
                return true;
        }
        return false;
    }
}
