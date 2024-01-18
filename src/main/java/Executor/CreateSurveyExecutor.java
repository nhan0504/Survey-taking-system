package Executor;

import Survey.Survey;

public class CreateSurveyExecutor implements Executor<Survey> {
    public Survey currentSurvey;
    @Override
    public void execute(int option) {
        System.out.println("Executing option" + option);
    }

    @Override
    public Survey getCurrentObject() {
        return this.currentSurvey;
    }
}
