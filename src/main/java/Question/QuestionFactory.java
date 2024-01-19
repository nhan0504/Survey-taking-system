package Question;

import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

public class QuestionFactory {
    int maxQuestionPrompt = 100;
    public static Question createTrueFalse() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                return new TrueFalse(input);
            }
        }
    }

    public static Question createMultipleChoice() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                MultipleChoice question = new MultipleChoice(input);
                question.getOptions();
                return question;
            }
        }
    }

    public static Question createShortAnswer() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                return new ShortAnswer(input);
            }
        }
    }

    public static Question createEssay() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                return new Essay(input);
            }
        }
    }

    public static Question createDate() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                return new ValidDate(input);
            }
        }
    }

    public static Question createMatching() {
        String input;
        while (true) {
            input = getUserInput();
            if (input.length() <= 100) {
                Matching question = new Matching(input);
                question.getOptions();
                return question;
            }
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prompt for your question: ");
        return scanner.nextLine();
    }
}
