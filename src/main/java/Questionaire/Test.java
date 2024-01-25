package Questionaire;

import Executor.CreateTestExecutor;
import Menu.Menu;
import Menu.CreateMenu;
import Question.Question;
import Utilities.Utilities;

import java.io.File;
import java.util.*;

public class Test extends Questionnaire {
    public static class Grade {
        double totalPossible = 100;
        double totalGrade;
        double totalGradable;
        double pointEach;

        private Grade(double pointEach) {
            this.totalGrade = totalPossible;
            this.totalGradable = totalPossible;
            this.pointEach = pointEach;
        }

        public void setTotalGrade(double totalGrade) {
            this.totalGrade = totalGrade;
        }

        public void setTotalGradable(double totalGradable) {
            this.totalGradable = totalGradable;
        }

        public double getPointEach() {
            return pointEach;
        }

        public double getTotalGrade() {
            return totalGrade;
        }

        public double getTotalGradable() {
            return totalGradable;
        }

        protected double getTotalPossible() {
            return totalPossible;
        }
    }

    private static final String saveDirectory = "tests";
    List<HashSet<String>> correctAnswers;

    private Test() {
        super();
        this.correctAnswers = new ArrayList<>();
    }

    public static Test create() {
        Test newTest = new Test();
        Menu createMenu = new CreateMenu(new CreateTestExecutor(newTest));

        while (true) {
            String testName = getFileName("test");

            File folder = new File(saveDirectory + "\\" + testName);
            if (!folder.exists()) {
                newTest.name = testName;
                break;
            } else {
                System.out.println("A test with this name already exist");
            }
        }

        createMenu.run();

        return newTest;
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
    public Question addTF() {
        Question question = super.addTF();
        correctAnswers.add(new HashSet<>());
        getCorrectAnswer(question);
        return question;
    }

    @Override
    public Question addMultipleChoice() {
        Question question = super.addMultipleChoice();
        correctAnswers.add(new HashSet<>());
        getCorrectAnswer(question);
        return question;
    }

    @Override
    public Question addShortAnswer() {
        Question question = super.addShortAnswer();
        correctAnswers.add(new HashSet<>());
        getCorrectAnswer(question);
        return question;
    }

    @Override
    public Question addEssay() {
        Question question = super.addEssay();
        correctAnswers.add(new HashSet<>());
        return question;
    }

    @Override
    public Question addDate() {
        Question question = super.addDate();
        correctAnswers.add(new HashSet<>());
        getCorrectAnswer(question);
        return question;
    }

    @Override
    public Question addMatching() {
        Question question = super.addMatching();
        correctAnswers.add(new HashSet<>());
        getCorrectAnswer(question);
        return question;
    }

    private void getCorrectAnswer(Question question) {
        Scanner scanner = new Scanner(System.in);
        question.display();

        for (int i = 0; i < question.numResponse; i++) {
            while (true) {
                int displayIndex = i + 1;
                System.out.print("Enter correct answer " + displayIndex + " for this question: ");
                String correctAnswer = scanner.nextLine();
                if (question.isValidAnswer(correctAnswer)) {
                    correctAnswers.get(correctAnswers.size() - 1).add(correctAnswer);
                    break;
                } else {
                    System.out.println("Wrong format");
                }
            }
        }
    }

    public void displayWithCorrectAnswer() {
        if (this.questions.isEmpty()) {
            System.out.println("Cannot display empty");
            return;
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Start-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();
        for (int i = 0; i < questions.size(); i++) {
            int displayIndex = i + 1;
            System.out.print(displayIndex + ". ");
            questions.get(i).display();

            System.out.print("The correct answer is: ");
            Iterator<String> answer = correctAnswers.get(i).iterator();
            while (answer.hasNext()) {
                System.out.print(answer.next());
                if (answer.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-End-~--~-~-~-~-~-~-~-~-~-~-~-~-~");
    }

    public static void grade() {
        Test test;
        try {
            test = getTestToGrade();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Test response;
        try {
            response = getTestResponseToGrade(test);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        double pointEach = (double) 100 / response.questions.size();
        Grade grade = new Grade(pointEach);
        for (int i = 0; i < response.questions.size(); i++) {
            response.questions.get(i).getGrade(response.correctAnswers.get(i), grade);
        }
        int numEssay = (int) ((grade.getTotalPossible() - grade.getTotalGradable()) / grade.getPointEach());
        System.out.println("You receive an " + grade.getTotalGrade() + " on the test. The test was worth " +
                            grade.getTotalPossible() + " points, but only " + grade.getTotalGradable() +
                            " of those points could be graded because there was " + numEssay + " essay question");
    }

    private static Test getTestToGrade() throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<String> tests = Utilities.getFolderItemName("tests");
        if (tests.isEmpty()) {
            throw new Exception("No test to grade");
        }
        Utilities.display(tests);

        while (true) {
            System.out.print("Select an existing test to grade. Enter a number:  ");
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, tests.size() + 1)) {
                int index = Integer.parseInt(input) - 1;
                String path = saveDirectory + "\\" + tests.get(index) + "\\" + tests.get(index) + ".txt";
                return Utilities.deserialize(path, Test.class);
            }
        }
    }
    private static Test getTestResponseToGrade(Test test) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> responses = Utilities.getFolderItemName("tests\\" + test.name);
        responses.remove(test.name + "txt");
        if (responses.isEmpty()) {
            throw new Exception("No response to grade");
        }
        Utilities.display(responses);

        while (true) {
            System.out.print("Select an existing response to grade. Enter a number: ");
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, responses.size() + 1)) {
                int index = Integer.parseInt(input) - 1;
                String path = saveDirectory + "\\" + test.name + "\\" + responses.get(index);
                return Utilities.deserialize(path, Test.class);
            }
        }
    }
}
