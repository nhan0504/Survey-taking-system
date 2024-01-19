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
        System.out.println(this.question + " Enter the letter in front of the choice. Ex: A");
        char index = 'A';
        for (String option : this.options) {
            System.out.print(index++ + ") ");
            System.out.println(option);
        }
    }

    public void getOptions() {
        Scanner scanner = new Scanner(System.in);

        int maxNumOption = 10;
        int numOption = 0;

        while (true) {
            System.out.print("How many options do you want to add? Must be less than " + maxNumOption + ": ");
            String input = scanner.nextLine();
            try {
                numOption = Integer.parseInt(input);
                if (numOption <= 0 || numOption >= maxNumOption) continue;
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }

        for (int i = 0; i < numOption; i++) {
            int index = i + 1;
            System.out.print("Enter option " + index + ": ");
            String option = scanner.nextLine();
            this.options.add(option);
        }
    }

    public boolean isValidAnswer(String answer) {
        return answer.length() == 1 && 'A' <= answer.charAt(0) && answer.charAt(0) < 'A' + this.options.size();
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
