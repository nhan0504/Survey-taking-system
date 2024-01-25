package Questionaire;

import Executor.CreateTestExecutor;
import Menu.Menu;
import Menu.CreateMenu;
import Question.Question;

import java.io.File;
import java.util.*;

public class Test extends Questionnaire {
    private static final String saveDirectory = "tests";
    List<HashSet<String>> correctAnswers;

    private Test(){
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

    public void grade() {
    }
}
