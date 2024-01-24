package Questionaire;

import java.util.ArrayList;

public class Test extends Questionnaire {
    private static final String saveDirectory = "tests";

    private Test(){
        this.name = "";
        this.questions = new ArrayList<>();
    }

    public static Test create() {
        return new Test();
    }

    public void save() {
        this.save(saveDirectory);
    }

    public void take() {
        this.take(saveDirectory);
    }

    public static Test load() {
        return Questionnaire.load(Test.class, saveDirectory);
    }

    @Override
    public void tabulate() {

    }

    public void displayWithAnswer() {
    }

    public void grade() {
    }
}
