package Question;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    protected String question;
    private List<String> answer;

    public Question(String question) {
        this.question = question;
    }

    protected String getQuestion() {
        return this.question;
    }

    public void setAnswer(String answer) {
        this.answer.add(answer);
    }

    public List<String> getAnswer() {
        return this.answer;
    }

    public void display() {
        System.out.println(this.question);
    }
}
