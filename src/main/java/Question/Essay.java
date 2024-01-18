package Question;

import java.util.List;
import java.util.Scanner;

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

    @Override
    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new prompt for question");
        this.question = scanner.nextLine();
    }
}
