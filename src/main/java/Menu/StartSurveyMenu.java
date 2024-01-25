package Menu;

import Executor.Executor;

import java.util.ArrayList;
import java.util.List;

public final class StartSurveyMenu extends Menu {
    public StartSurveyMenu(Executor executor) {
        List<String> options = new ArrayList<>();
        options.add("Create a new survey");
        options.add("Display current survey");
        options.add("Load an existing survey");
        options.add("Save the current survey");
        options.add("Take the current survey");
        options.add("Modify current survey");
        options.add("Tabulate current survey");
        options.add("Go back");
        this.options = options;
        this.executor = executor;
    }
}
