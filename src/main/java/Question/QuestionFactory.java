package Question;

import Utilities.Utilities;

import java.util.Scanner;

public class QuestionFactory {
    public static Question createTrueFalse() {
        String input;
        while (true) {
            input = getUserInput();
            if (Question.validPrompt(input)) {
                return new TrueFalse(input);
            }
        }
    }

    public static Question createMultipleChoice() {
        Scanner scanner = new Scanner(System.in);

        String input;
        MultipleChoice question;

        while (true) {
            input = getUserInput();
            if (Question.validPrompt(input)) {
                question = new MultipleChoice(input);
                break;
            }
        }

        question.getOptions();

        while (true) {
            System.out.print("How many response can this question take? ");
            String numResponse = scanner.nextLine();
            if (Utilities.checkNumberInRange(numResponse, 1, question.options.size() + 1)) {
                question.numResponse = Integer.parseInt(numResponse);
                return question;
            }
        }
    }

    public static Question createShortAnswer() {
        Scanner scanner = new Scanner(System.in);

        String input;
        ShortAnswer question;

        while (true) {
            input = getUserInput();
            if (Question.validPrompt(input)) {
                question = new ShortAnswer(input);
                break;
            }
        }

        while (true) {
            System.out.print("How many response can this question take? ");
            String numResponse = scanner.nextLine();
            if (Utilities.checkNumberInRange(numResponse, 1, 11)) {
                question.numResponse = Integer.parseInt(numResponse);
                return question;
            }
        }
    }

    public static Question createEssay() {
        Scanner scanner = new Scanner(System.in);

        String input;
        Essay question;

        while (true) {
            input = getUserInput();
            if (Question.validPrompt(input)) {
                question = new Essay(input);
                break;
            }
        }

        while (true) {
            System.out.print("How many response can this question take? ");
            String numResponse = scanner.nextLine();
            if (Utilities.checkNumberInRange(numResponse, 1, 11)) {
                question.numResponse = Integer.parseInt(numResponse);
                return question;
            }
        }
    }

    public static Question createDate() {
        Scanner scanner = new Scanner(System.in);

        String input;
        ValidDate question;

        while (true) {
            input = getUserInput();
            if (Question.validPrompt(input)) {
                question = new ValidDate(input);
                break;
            }
        }

        while (true) {
            System.out.print("How many response can this question take? ");
            String numResponse = scanner.nextLine();
            if (Utilities.checkNumberInRange(numResponse, 1, 11)) {
                question.numResponse = Integer.parseInt(numResponse);
                return question;
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
                question.numResponse = question.columns.get(0).size();
                return question;
            }
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prompt for your question (Max 100 char): ");
        return scanner.nextLine();
    }
}
