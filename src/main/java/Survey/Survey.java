package Survey;

import Question.Question;

import java.io.*;
import java.util.*;

public class Survey implements Serializable {
    List<Question> questions;

    public Survey() {
        questions = new ArrayList<>();
    }

    public static void displaySurvey() {
        System.out.println("Display survey");
        Survey survey = loadSurvey();
        survey.display();
    }

    public static void createSurvey() {
        System.out.println("Create survey");
        Survey survey = new Survey();
        survey.addQuestion(new Question("HIHII ???"));
        survey.addQuestion(new Question("Am I a question?"));
        saveSurvey(survey);
    }

    public static void saveSurvey(Survey survey) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter survey name to save");
        String surveyName = scanner.nextLine();

        File directory = new File("surveys\\" + surveyName);
        directory.mkdir();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("surveys\\" + surveyName + "\\" + surveyName + ".txt"));
            outputStream.writeObject(survey);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    public static void modifySurvey() {
        System.out.println("modify");
        Survey survey = loadSurvey();
    }

    public static void takeSurvey() {
        System.out.println("take survey");
        Survey survey = loadSurvey();
    }

    public static Survey loadSurvey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter survey name: ");
        String input = scanner.nextLine();

        Survey survey = new Survey();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("surveys\\" + input + "\\" + input + ".txt"));
            survey = (Survey) inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return survey;
    }

    public void display() {
        for (Question question : questions) {
            question.display();
        }
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
}
