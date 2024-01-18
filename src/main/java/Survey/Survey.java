package Survey;

import Executor.CreateSurveyExecutor;
import Menu.CreateSurveyMenu;
import Menu.Menu;
import Question.Question;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many question do you want on the survey? ");
        String input = scanner.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            createMenu.display();
            createMenu.getInputAndExecute();
        }

        return newSurvey;
    }

    public static void displaySurvey(Survey currentSurvey) {
        for (Question question : currentSurvey.questions) {
            question.display();
        }
    }

    public static void loadSurvey(Survey currentSurvey) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter survey name to load: ");
        String input = scanner.nextLine();

        String path = "surveys\\" + input + "\\" + input + ".txt";
        currentSurvey = deserialize(path);
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
        for(Question question : currentSurvey.questions) {
            question.display();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter answer: ");
            String input = scanner.nextLine();

            question.setAnswer(input);
        }
        saveSurveyAnswer(currentSurvey);
    }

    public static void modifySurvey(Survey currentSurvey) {
        System.out.println("modify");
    }

    public static void addTF(Survey currentSurvey) {
        System.out.println("Adding true false question");
        currentSurvey.addQuestion(new Question("TRUE ???"));
    }

    public static void addMultipleChoice(Survey currentSurvey) {
        System.out.println("Adding multiple choice question");
        currentSurvey.addQuestion(new Question("Muti hihi?"));
    }

    public static void addShortAnswer(Survey currentSurvey) {
        System.out.println("Adding short answer question");
        currentSurvey.addQuestion(new Question("Am I a question?"));
    }

    public static void addEssay(Survey currentSurvey) {
        System.out.println("Adding essay question");
        currentSurvey.addQuestion(new Question("Is this an essay?"));
    }

    public static void addDate(Survey currentSurvey) {
        System.out.println("Adding date question");
        currentSurvey.addQuestion(new Question("What day is it?"));
    }

    public static void addMatching(Survey currentSurvey) {
        System.out.println("Adding matching question");
        currentSurvey.addQuestion(new Question("Are you a match maker?"));
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

    private void addQuestion(Question question) {
        this.questions.add(question);
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
