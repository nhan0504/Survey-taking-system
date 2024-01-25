package Question;

import java.io.Serializable;
import java.util.*;

public abstract class Question implements Serializable {
    static int maxPromptLength = 100;
    public int numResponse;
    protected String question;
    protected HashSet<String> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new HashSet<>();
    }

    public List<String> getAnswer() {
        Scanner scanner = new Scanner(System.in);
        List<String> answers = new ArrayList<>();
        String answer;

        for (int i = 0; i < numResponse; i++) {
            while (true) {
                int displayIndex = i + 1;
                System.out.print("Enter answer " + displayIndex + ": ");
                answer = scanner.nextLine();
                if (isValidAnswer(answer)) {
                    break;
                } else {
                    System.out.println("Answer is invalid");
                }
            }
            answers.add(answer);
            this.answers.add(answer);
        }
        return answers;
    }

    protected static boolean validPrompt(String prompt) {
        return !prompt.isEmpty() && prompt.length() < maxPromptLength;
    }

    public abstract boolean isValidAnswer(String answer);

    public abstract void display();

    public void modify() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new prompt for question: ");
            String input = scanner.nextLine();
            if (validPrompt(input)) {
                this.question = input;
                break;
            }
        }
    }

    public void tabulate(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
