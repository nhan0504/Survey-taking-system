package Survey;

import Executor.CreateSurveyExecutor;
import Menu.CreateSurveyMenu;
import Menu.Menu;
import Question.Question;
import Question.QuestionFactory;

import java.io.*;
import java.util.*;

public class Survey implements Serializable {
    String name;
    List<Question> questions;

    private Survey() {
        this.name = "";
        this.questions = new ArrayList<>();
    }

    public static Survey createSurvey() {
        Survey newSurvey = new Survey();
        Menu<Survey> createMenu = new CreateSurveyMenu(new CreateSurveyExecutor(newSurvey));

        boolean running = true;
        while (running) {
            createMenu.display();
            running = createMenu.getInputAndExecute();
        }

        return newSurvey;
    }

    public static void displaySurvey(Survey currentSurvey) {
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Survey-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();
        int index = 1;
        for (Question question : currentSurvey.questions) {
            System.out.print(index++ + ". ");
            question.display();
            System.out.println();
        }
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~End Survey-~-~-~-~-~-~-~-~-~-~-~-~-~");
    }

    public static Survey loadSurvey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter survey name to load: ");
        String input = scanner.nextLine();

        String path = "surveys\\" + input + "\\" + input + ".txt";
        return deserialize(path);
    }

    public static void saveSurvey(Survey currentSurvey) {
        boolean isSaved = false;

        while (!isSaved) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter survey name to save");
            String surveyName = scanner.nextLine();

            currentSurvey.name = surveyName;

            File directory = new File("surveys\\" + surveyName);
            if (directory.mkdir()) {
                String path = "surveys\\" + surveyName + "\\" + surveyName + ".txt";
                serialize(path, currentSurvey);
                System.out.println("Saved");
                isSaved = true;
            } else {
                System.out.println("Survey already exist");
            }
        }
    }

    public static void takeSurvey(Survey currentSurvey) {
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Survey-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();
        int index = 1;
        for(Question question : currentSurvey.questions) {
            System.out.print(index++ + ". ");
            question.display();
            question.getAnswer();
            System.out.println();
        }
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~End Survey-~-~-~-~-~-~-~-~-~-~-~-~-~");
        saveSurveyAnswer(currentSurvey);
        System.out.println();
    }

    public static void modifySurvey(Survey currentSurvey) {
        System.out.print("Which question do you want to modify? ");
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        currentSurvey.questions.get(index).modify();
    }

    public static void addTF(Survey currentSurvey) {
        Question question = QuestionFactory.createTrueFalse();
        currentSurvey.questions.add(question);
    }

    public static void addMultipleChoice(Survey currentSurvey) {
        Question question = QuestionFactory.createMultipleChoice();
        currentSurvey.questions.add(question);
    }

    public static void addShortAnswer(Survey currentSurvey) {
        Question question = QuestionFactory.createShortAnswer();
        currentSurvey.questions.add(question);
    }

    public static void addEssay(Survey currentSurvey) {
        Question question = QuestionFactory.createEssay();
        currentSurvey.questions.add(question);
    }

    public static void addDate(Survey currentSurvey) {
        Question question = QuestionFactory.createDate();
        currentSurvey.questions.add(question);
    }

    public static void addMatching(Survey currentSurvey) {
        Question question = QuestionFactory.createMatching();
        currentSurvey.questions.add(question);
    }

    private static void saveSurveyAnswer(Survey survey) {
        boolean isSaved = false;

        while (!isSaved) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name to save answer: ");
            String name = scanner.nextLine();

            String path = "surveys\\" + survey.name + "\\" + name + ".txt";
            File file = new File(path);
            if (!file.exists()) {
                serialize(path, survey);
                isSaved = true;
            } else {
                System.out.println("Name already exists");
            }
        }
    }

    private static void serialize(String path, Survey survey) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(survey);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static Survey deserialize(String path) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            return (Survey) inputStream.readObject();
        } catch (Exception e) {
            System.out.println("Cannot find survey");
        }
        return null;
    }
}
