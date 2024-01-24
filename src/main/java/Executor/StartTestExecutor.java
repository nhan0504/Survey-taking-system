package Executor;

import Questionaire.Test;

public class StartTestExecutor implements Executor{
    private Test currentTest;
    @Override
    public boolean execute(int option) {
        switch (option) {
            case 0:
                //Create test
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
                //Display with answer
                if (currentTest == null) {
                    System.out.println("Must load or create a test before displaying");
                } else {
                    currentTest.displayWithCorrectAnswer();
                }
                return true;
            case 3:
                //Load a test
                currentTest = Test.load();
                return true;
            case 4:
                //Save current test
                if (currentTest == null) {
                    System.out.println("Must create a test before saving");
                } else {
                    currentTest.save();
                }
                return true;
            case 5:
                //Take current test
                if (currentTest == null) {
                    System.out.println("Must load or create a test before taking");
                } else {
                    currentTest.take();
                }
                return true;
            case 6:
                //Modify current test
                if (currentTest == null) {
                    System.out.println("Must load or create a test before modifying");
                } else {
                    currentTest.modify();
                }
                return true;
            case 7:
                //Tabulate the answer for the test
                if (currentTest == null) {
                    System.out.println("Must load or create a test before tabulating");
                } else {
                    currentTest.tabulate();
                }
                return true;
            case 8:
                //Grade the current test
                if (currentTest == null) {
                    System.out.println("Must load or create a test before grading");
                } else {
                    currentTest.grade();
                }
                return true;
        }
        return false;
    }
}
