package Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleChoice extends Question {
    List<String> options;
    public MultipleChoice(String question) {
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

    @Override
    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to modify the question prompt? ");
        String answer = scanner.nextLine();
        if (answer.contentEquals("yes")) {
            System.out.print("Enter new prompt for question");
            this.question = scanner.nextLine();
        }
        System.out.print("Do you want to modify the option? ");
        answer = scanner.nextLine();
        if (answer.contentEquals("yes")) {
            System.out.println("Which option do you want to modify?");
            int option = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new value for option " + option + ": ");
            this.options.set(option - 1, scanner.nextLine());
        }
    }
}
