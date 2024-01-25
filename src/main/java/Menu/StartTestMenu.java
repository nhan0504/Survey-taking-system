package Menu;

import Executor.Executor;

import java.util.ArrayList;
import java.util.List;

public class StartTestMenu extends Menu{
    public StartTestMenu(Executor executor) {
        List<String> options = new ArrayList<>();
        options.add("Create a new test");
        options.add("Display current test without answer");
        options.add("Display current test with answer");
        options.add("Load an existing test");
        options.add("Save the current test");
        options.add("Take the current test");
        options.add("Modify current test");
        options.add("Tabulate current test");
        options.add("Grade a test");
        options.add("Go back");
        this.options = options;
        this.executor = executor;
    }
}
