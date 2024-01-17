package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    protected String question;
    private List<String> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void setAnswer(String answer) {
        this.answers.add(answer);
    }

    public void display() {
        System.out.println(this.question);
    }
}
