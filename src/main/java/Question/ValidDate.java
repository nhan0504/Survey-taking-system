package Question;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidDate extends Question {
    public ValidDate(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question + " Enter date in the format yyyy-mm-dd");
    }

    public boolean isValidAnswer(String answer) {
        try {
            LocalDate.parse(answer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
