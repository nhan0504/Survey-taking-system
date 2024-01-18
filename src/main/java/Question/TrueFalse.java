package Question;

enum TrueFalseAnswer {
    TRUE,
    FALSE
}

public class TrueFalse extends Question {
    public TrueFalse(String question) {
        super(question);
    }

    @Override
    public void display() {
        System.out.println(this.question);
    }

    public boolean isValidAnswer(String answer) {
        return true;
    }
}
