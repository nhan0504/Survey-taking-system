package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Question implements Serializable {
    int numResponse;
    protected String question;
    protected List<String> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";

        for (int i = 0; i < numResponse; i++) {
            while (true) {
                System.out.print("Enter answer: ");
                answer = scanner.nextLine();
                if (isValidAnswer(answer)) {
                    break;
                } else {
                    System.out.println("Answer is invalid");
                }
            }
            this.answers.add(answer);
        }
    }

    public abstract boolean isValidAnswer(String answer);

    public abstract void display();

    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new prompt for question: ");
        this.question = scanner.nextLine();
    }
}
