package Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matching extends Question{
    public List<String> options;

    public Matching(String question) {
        super(question);
        this.options = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println(this.question);
        for (String option : this.options) {
            System.out.println(option);
        }
    }

    public void getOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many options do you want to add? ");
        String input = scanner.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            int index = i + 1;
            System.out.print("Enter option " + index + ": ");
            String option = scanner.nextLine();
            this.options.add(option);
        }
    }

    public boolean isValidAnswer(String answer) {
        return true;
    }
}
