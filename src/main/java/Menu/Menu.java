package Menu;

import Executor.Executor;
import Utilities.Utilities;

import java.util.*;

public abstract class Menu {
    protected List<String> options;
    protected Executor executor;

    public void run() {
        while(true) {
            display();
            if (!getInputAndExecute()) break;
            System.out.println();
            System.out.println();
        }
    }

    private void display() {
        for (int i = 0; i < options.size(); i++) {
            int index = i + 1;
            System.out.println(index + ". " + options.get(i));
        }
    }

    private int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Choose an option: ");
            input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, options.size() + 1)) {
                return Integer.parseInt(input);
            }
        }
    }

    private boolean getInputAndExecute() {
        int option = getValidInput();
        return executor.execute(option - 1);
    }
}
