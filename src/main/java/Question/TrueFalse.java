package Question;

import java.util.Scanner;

enum TrueFalseAnswer {
    YES,
    NO
}

public class TrueFalse extends Question {
    public TrueFalse(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question + " Answer yes/no");
    }

    public boolean isValidAnswer(String answer) {
        answer = answer.toUpperCase();
        try {
            TrueFalseAnswer.valueOf(answer);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
