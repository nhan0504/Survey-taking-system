import Executor.StartSurveyExecutor;
import Menu.Menu;
import Menu.StartSurveyMenu;
import Survey.Survey;

import java.io.File;

public class SurveySystem {
    public static void main(String[] args) {
        File directory = new File(".\\surveys");
        directory.mkdir();

        Menu<Survey> menu = new StartSurveyMenu(new StartSurveyExecutor());

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}

