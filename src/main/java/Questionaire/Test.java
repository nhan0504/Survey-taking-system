package Questionaire;

import java.util.ArrayList;

public class Test extends Questionaire{
    private Test(){
        this.name = "";
        this.saveDirectory = "tests";
        this.questions = new ArrayList<>();
    }

    public static Test create() {
        return new Test();
    }

    public static Test load() {
        return new Test();
    }

    @Override
    public void tabulate() {

    }

    @Override
    public void take() {

    }

    public void displayWithAnswer() {
    }

    public void grade() {
    }
}
