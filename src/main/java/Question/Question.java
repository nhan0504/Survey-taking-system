package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public abstract class Question implements Serializable {
    static int maxPromptLength = 100;
    public int numResponse;
    protected String question;
    protected HashSet<String> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new HashSet<>();
    }

    public void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";

        for (int i = 0; i < numResponse; i++) {
            while (true) {
                System.out.print("Enter answer: ");
                answer = scanner.nextLine();
                if (isValidAnswer(answer)) {
                    break;
                } else {
                    System.out.println("Answer is invalid");
                }
            }
            this.answers.add(answer);
        }
    }

    protected static boolean validPrompt(String prompt) {
        return !prompt.isEmpty() && prompt.length() < maxPromptLength;
    }

    public abstract boolean isValidAnswer(String answer);

    public abstract void display();

    public void modify() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new prompt for question: ");
            String input = scanner.nextLine();
            if (validPrompt(input)) {
                this.question = input;
                break;
            }
        }
    }
}
