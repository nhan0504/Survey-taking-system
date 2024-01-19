package Question;

import Utilities.Utilities;

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
            if (Utilities.checkNumberInRange(input, 1, maxNumOption)) {
                numOption = Integer.parseInt(input);
                break;
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

        TrueFalse modifyPrompt = new TrueFalse("Do you want to modify the question prompt? ");
        modifyPrompt.display();
        modifyPrompt.getAnswer();
        if (modifyPrompt.answers.get(0).equals("yes")) {
            System.out.print("Enter new prompt for question: ");
            this.question = scanner.nextLine();
        }

        TrueFalse modifyOption = new TrueFalse("Do you want to modify the option? ");
        modifyOption.display();
        modifyOption.getAnswer();
        if (modifyOption.answers.get(0).equals("yes")) {
            while (true) {
                System.out.print("Which option do you want to modify? Please enter a number ");
                String input = scanner.nextLine();
                if (Utilities.checkNumberInRange(input, 1, this.options.size() + 1)) {
                    int index = Integer.parseInt(input);
                    System.out.print("Enter new value for option " + index + ": ");
                    this.options.set(index - 1, scanner.nextLine());
                    break;
                }
            }
        }
    }
}
