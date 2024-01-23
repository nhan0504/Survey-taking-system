package Menu;

import Executor.Executor;

import java.util.ArrayList;
import java.util.List;

public class CreateTestMenu extends Menu{
    public CreateTestMenu(Executor executor) {
        List<String> options = new ArrayList<>();
        options.add("Add T/F question");
        options.add("Add multiple choice question");
        options.add("Add short answer question");
        options.add("Add essay question");
        options.add("Add date question");
        options.add("Add matching question");
        options.add("Go back");
        this.options = options;
        this.executor = executor;
    }
}
