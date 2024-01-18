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

        boolean running = true;
        while(running) {
            menu.display();
            running = menu.getInputAndExecute();
        }
    }
}

