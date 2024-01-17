import Menu.Menu;
import Menu.StartMenu;

import java.io.File;

public class SurveySystem {
    public static void main(String[] args) {
        File directory = new File(".\\surveys");
        directory.mkdir();

        Menu menu = new StartMenu();

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}

