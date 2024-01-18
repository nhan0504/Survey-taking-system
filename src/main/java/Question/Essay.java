package Question;

import java.util.List;

public class Essay extends Question{
    public Essay(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question);
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return true;
    }
}
