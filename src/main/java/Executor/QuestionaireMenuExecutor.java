package Executor;

import Menu.Menu;
import Menu.StartSurveyMenu;
import Menu.StartTestMenu;

public class QuestionaireMenuExecutor implements Executor {
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                Menu surveyMenu = new StartSurveyMenu(new StartSurveyExecutor());
                surveyMenu.run();
                return true;
            case 1:
                Menu testMenu = new StartTestMenu(new StartTestExecutor());
                testMenu.run();
                return true;
        }
        return false;
    }
}