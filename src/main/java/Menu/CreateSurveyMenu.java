package Menu;

import Executor.CreateSurveyExecutor;
import Executor.Executor;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;

public class CreateSurveyMenu extends Menu<Survey> {
    public CreateSurveyMenu(Executor<Survey> executor) {
        List<String> options = new ArrayList<>();
        options.add("Add T/F question");
        options.add("Add multiple choice question");
        options.add("Add short answer question");
        options.add("Add essay question");
        options.add("Add date question");
        options.add("Add matching question");
        options.add("Go back");
        this.options = options;
        this.executor = executor;
    }
}
