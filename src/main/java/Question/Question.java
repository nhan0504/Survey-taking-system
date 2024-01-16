package Question;

import java.io.Serializable;

public class Question<T> implements Serializable {
    protected String question;
    private T answer;

    public Question(String question) {
        this.question = question;
    }

    protected String getQuestion() {
        return this.question;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public T getAnswer() {
        return this.answer;
    }

    public void display() {
        System.out.println(this.question);
    }
}
