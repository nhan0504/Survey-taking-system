package Menu;

import Executor.Executor;
import Utilities.Utilities;

import java.util.*;

public abstract class Menu {
    protected List<String> options;
    protected Executor executor;

    public void run() {
        do {
            this.display();
        }
        while(getInputAndExecute());
    }

    private void display() {
        Utilities.display(options);
    }

    private boolean getInputAndExecute() {
        int optionIndex = Utilities.getOption("Choose an option: ", 1, this.options.size() + 1) - 1;
        System.out.println();
        boolean status = executor.execute(optionIndex);
        System.out.println();
        return status;
    }
}
