package Question;

import java.util.Date;
import java.util.List;

public class ValidDate extends Question {
    public ValidDate(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question);
    }

    public boolean isValidAnswer(String answer) {
        return true;
    }
}
