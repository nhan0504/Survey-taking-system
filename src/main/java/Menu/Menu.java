package Menu;

import Executor.Executor;
import Utilities.Utilities;

import java.util.*;

public abstract class Menu<T> {
    protected List<String> options;
    protected Executor<T> executor;

    public void display() {
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

    public boolean getInputAndExecute() {
        boolean status = true;
        try {
            int option = getValidInput();
            status = executor.execute(option);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
