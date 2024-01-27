package Executor;

import Questionaire.Test;

public class StartTestExecutor implements Executor{
    private Test currentTest;
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                currentTest = Test.create();
                return true;
            case 1:
                if (currentTest == null) {
                    System.out.println("Must load or create a test before displaying");
                } else {
                    currentTest.display();
                }
                return true;
            case 2:
                if (currentTest == null) {
                    System.out.println("Must load or create a test before displaying");
                } else {
                    currentTest.displayWithCorrectAnswer();
                }
                return true;
            case 3:
                currentTest = Test.load();
                return true;
            case 4:
                if (currentTest == null) {
                    System.out.println("Must create a test before saving");
                } else {
                    currentTest.save();
                }
                return true;
            case 5:
                if (currentTest == null) {
                    System.out.println("Must load or create a test before taking");
                } else {
                    currentTest.take();
                }
                return true;
            case 6:
                if (currentTest == null) {
                    System.out.println("Must load or create a test before modifying");
                } else {
                    currentTest.modify();
                    currentTest.save();
                }
                return true;
            case 7:
                if (currentTest == null) {
                    System.out.println("Must load or create a test before tabulating");
                } else {
                    currentTest.tabulate();
                }
                return true;
            case 8:
                Test.grade();
                return true;
        }
        return false;
    }
}
