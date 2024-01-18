package Menu;

import Executor.StartSurveyExecutor;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;

public final class StartSurveyMenu extends Menu<Survey> {
    public StartSurveyMenu() {
        List<String> options = new ArrayList<>();
        options.add("Create a new survey");
        options.add("Display an existing survey");
        options.add("Load an existing survey");
        options.add("Save the current survey");
        options.add("Take the current survey");
        options.add("Modifying the current survey");
        options.add("Quit");
        this.options = options;
        this.executor = new StartSurveyExecutor();
    }
}
