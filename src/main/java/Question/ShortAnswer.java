package Question;

import java.util.List;

public class ShortAnswer extends Question{
    public ShortAnswer(String question) {
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
