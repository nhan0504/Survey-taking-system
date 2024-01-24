package Executor;

import Questionaire.Survey;
import Questionaire.Test;

public class CreateTestExecutor implements Executor{
    public Test currentTest;
    public CreateTestExecutor(Test currentTest) {
        this.currentTest = currentTest;
    }
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentTest.addTF();
                return true;
            case 1:
                currentTest.addMultipleChoice();
                return true;
            case 2:
                currentTest.addShortAnswer();
                return true;
            case 3:
                currentTest.addEssay();
                return true;
            case 4:
                currentTest.addDate();
                return true;
            case 5:
                currentTest.addMatching();
                return true;
        }
        return false;
    }
}
