package Question;

import java.util.List;
import java.util.Scanner;

public class Essay extends Question{
    int maxCharacter = 200;
    public Essay(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question + " (Max " + maxCharacter + " char)");
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return answer.length() <= maxCharacter;
    }
}
