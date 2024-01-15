package Menu;

import java.util.*;

public abstract class Menu {
    protected List<Option> options = new ArrayList<>();

    public void display() {
        for (int i = 0; i < options.size(); i++) {
            int index = i + 1;
            System.out.println(index + ". " + options.get(i).getOption());
        }
    }

    private int validOption(String input) throws Exception {
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

    public void getInputAndExecute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: ");
        String input = scanner.nextLine();

        try {
            int idx = validOption(input);
            options.get(idx).getAction().run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
