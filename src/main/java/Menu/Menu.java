package Menu;

import Executor.Executor;

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

    private int getValidInput() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
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
