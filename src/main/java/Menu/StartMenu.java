package Menu;

import Survey.Survey;

import java.util.ArrayList;
import java.util.List;

public final class StartMenu extends Menu {
    public StartMenu() {
        List<String> options = new ArrayList<>();
        options.add("Display survey");
        options.add("Create a new survey");
        options.add("Modify a survey");
        options.add("Take a survey");
        options.add("Quit");
        this.options = options;
    }

    @Override
    protected void execute(int option) {
        switch (option) {
            case 0:
                Survey.displaySurvey();
                break;
            case 1:
                Survey.createSurvey();
                break;
            case 2:
                Survey.modifySurvey();
                break;
            case 3:
                Survey.takeSurvey();
                break;
            case 4:
                System.exit(0);
        }
    }
}
