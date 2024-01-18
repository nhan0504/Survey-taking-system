package Menu;

import Executor.Executor;
import Executor.StartSurveyExecutor;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;

public final class StartSurveyMenu extends Menu<Survey> {
    public StartSurveyMenu(Executor<Survey> executor) {
        List<String> options = new ArrayList<>();
        options.add("Create a new survey");
        options.add("Display current survey");
        options.add("Load an existing survey");
        options.add("Save the current survey");
        options.add("Take the current survey");
        options.add("Modify current survey");
        options.add("Quit");
        this.options = options;
        this.executor = executor;
    }
}
