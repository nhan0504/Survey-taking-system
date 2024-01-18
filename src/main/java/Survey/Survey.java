package Survey;

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

    public static void createSurvey() {
        System.out.println("Create survey");

        Survey survey = new Survey();
        survey.addQuestion(new Question("HIHII ???"));
        survey.addQuestion(new Question("Am I a question?"));

        saveSurvey(survey);
    }

    public static void displaySurvey() {
        System.out.println("Display survey");
        Survey survey = loadSurvey();
        for (Question question : survey.questions) {
            question.display();
        }
    }

    public static Survey loadSurvey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter survey name: ");
        String input = scanner.nextLine();

        String path = "surveys\\" + input + "\\" + input + ".txt";
        return deserialize(path);
    }

    public static void saveSurvey(Survey survey) {
        boolean isSaved = false;

        while (!isSaved) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter survey name to save");
            String surveyName = scanner.nextLine();

            survey.name = surveyName;

            File directory = new File("surveys\\" + surveyName);
            if (directory.mkdir()) {
                String path = "surveys\\" + surveyName + "\\" + surveyName + ".txt";
                serialize(path, survey);
                System.out.println("Saved");
                isSaved = true;
            } else {
                System.out.println("Survey already exist");
            }
        }
    }

    public static void takeSurvey() {
        System.out.println("take survey");
        Survey survey = loadSurvey();
        for(Question question : survey.questions) {
            question.display();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter answer: ");
            String input = scanner.nextLine();

            question.setAnswer(input);
        }
        saveSurveyAnswer(survey);
    }

    public static void modifySurvey() {
        System.out.println("modify");
        Survey survey = loadSurvey();
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

    public void addQuestion(Question question) {
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
