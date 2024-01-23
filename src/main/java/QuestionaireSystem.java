import Executor.QuestionaireMenuExecutor;
import Menu.Menu;
import Menu.QuestionaireMenu;

import java.io.File;

public class QuestionaireSystem {
    public static void main(String[] args) {
        File directory = new File(".\\surveys");
        directory.mkdir();

        Menu menu = new QuestionaireMenu(new QuestionaireMenuExecutor());
        menu.run();
    }
}

