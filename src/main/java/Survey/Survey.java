package Survey;

import Question.Question;

import java.io.Serializable;
import java.util.*;

public class Survey implements Serializable {
    List<Question> questions;

    public Survey() {
        questions = new ArrayList<>();
    }

    public void display() {
        for (Question question : questions) {
            question.display();
        }
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
}
