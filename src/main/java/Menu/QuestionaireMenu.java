package Menu;

import Executor.Executor;

import java.util.ArrayList;
import java.util.List;

public class QuestionaireMenu extends Menu{
    public QuestionaireMenu(Executor executor) {
        List<String> options = new ArrayList<>();
        options.add("Survey");
        options.add("Test");
        options.add("Quit");
        this.options = options;
        this.executor = executor;
    }
}
