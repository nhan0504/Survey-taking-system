package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Question implements Serializable {
    protected String question;
    protected List<String> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter answer: ");
            answer = scanner.nextLine();
            valid = isValidAnswer(answer);
        }
        this.answers.add(answer);
    }

    public abstract boolean isValidAnswer(String answer);

    public abstract void display();
}
