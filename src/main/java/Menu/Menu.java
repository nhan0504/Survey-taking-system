package Menu;

import Survey.Survey;

import java.util.*;

public abstract class Menu {
    protected List<String> options;

    public void display() {
        for (int i = 0; i < options.size(); i++) {
            int index = i + 1;
            System.out.println(index + ". " + options.get(i));
        }
    }

    private int getValidInput() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: ");
        String input = scanner.nextLine();

        return isValid(input);

    }

    private int isValid(String input) throws Exception {
        int idx;
        try {
            idx = Integer.parseInt(input) - 1;
        } catch (Exception e) {
            throw new Exception("Invalid option");
        }
        if (idx < 0 || idx >= options.size()) {
            throw new Exception("Invalid option");
        }
        return idx;
    }

    protected abstract void execute(int option);

    public void getInputAndExecute() {
        try {
            int option = getValidInput();
            execute(option);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
