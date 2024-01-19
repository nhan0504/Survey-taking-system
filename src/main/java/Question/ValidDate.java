package Question;

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
        System.out.println(this.question + " Enter date in the format mm-dd-yyyy");
    }

    public boolean isValidAnswer(String answer) {
        String regex = "^\\d{2}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        return matcher.matches();
    }

    @Override
    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new prompt for question");
        this.question = scanner.nextLine();
    }
}
