package Question;

enum TrueFalseAnswer {
    TRUE,
    FALSE
}

public class TrueFalse extends Question<TrueFalseAnswer> {
    public TrueFalse(String question) {
        super(question);
    }
}
