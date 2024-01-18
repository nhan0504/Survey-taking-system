package Question;

import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

public class QuestionFactory {
    public static Question createTrueFalse() {
        String input = getUserInput();
        return new TrueFalse(input);
    }

    public static Question createMultipleChoice() {
        String input = getUserInput();
        MultipleChoice question = new MultipleChoice(input);
        question.getOptions();
        return question;
    }

    public static Question createShortAnswer() {
        String input = getUserInput();
        return new ShortAnswer(input);
    }

    public static Question createEssay() {
        String input = getUserInput();
        return new Essay(input);
    }

    public static Question createDate() {
        String input = getUserInput();
        return new ValidDate(input);
    }

    public static Question createMatching() {
        String input = getUserInput();
        Matching question = new Matching(input);
        question.getOptions();
        return question;
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prompt for your question: ");
        return scanner.nextLine();
    }
}
