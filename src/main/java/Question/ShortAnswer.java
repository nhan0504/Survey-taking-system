package Question;

import java.util.List;
import java.util.Scanner;

public class ShortAnswer extends Question{
    int maxCharacter = 50;
    public ShortAnswer(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question + " (Max " + maxCharacter + " char)");
    }

    public boolean isValidAnswer(String answer) {
        return answer.length() <= maxCharacter;
    }
}
