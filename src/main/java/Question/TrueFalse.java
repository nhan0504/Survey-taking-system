package Question;

import java.util.Scanner;

enum TrueFalseAnswer {
    TRUE,
    FALSE
}

public class TrueFalse extends Question {
    public TrueFalse(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question);
    }

    public boolean isValidAnswer(String answer) {
        return true;
    }

    @Override
    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new prompt for question");
        this.question = scanner.nextLine();
    }
}
