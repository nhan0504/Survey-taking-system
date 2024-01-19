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
        Scanner scanner = new Scanner(System.in);
        Survey newSurvey = new Survey();
        Menu<Survey> createMenu = new CreateSurveyMenu(new CreateSurveyExecutor(newSurvey));

        while (true) {
            System.out.print("Enter survey name: ");
            String surveyName = scanner.nextLine();

            File folder = new File("surveys\\" + surveyName);
            if (!folder.exists()) {
                newSurvey.name = surveyName;
                break;
            } else {
                System.out.println("A survey with this name already exist");
            }
        }

        boolean running = true;
        while (running) {
            createMenu.display();
            running = createMenu.getInputAndExecute();
        }

        return newSurvey;
    }

    public static void displaySurvey(Survey currentSurvey) {
        if (currentSurvey == null) {
            System.out.println("Must load or create a survey before displaying it");
            return;
        }

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
        File surveysFolder = new File("surveys");
        String[] allSurveys = surveysFolder.list();

        if (allSurveys.length == 0) {
            System.out.println("No surveys to load");
            return null;
        }

        for (int i = 1; i <= allSurveys.length; i++) {
            System.out.print(i + ". ");
            System.out.println(allSurveys[i - 1]);
        }


        Scanner scanner = new Scanner(System.in);
        String path;

        while(true) {
            System.out.print("Which survey do you want to load? Enter a number: ");
            String input = scanner.nextLine();

            try {
                int surveyIndex = Integer.parseInt(input) - 1;
                if (surveyIndex >= 0 && surveyIndex < allSurveys.length) {
                    path = "surveys\\" + allSurveys[surveyIndex] + "\\" + allSurveys[surveyIndex] + ".txt";
                    break;
                } else {
                    System.out.println("Number out of range");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }

        return deserialize(path);
    }

    public static void saveSurvey(Survey currentSurvey) {
        if (currentSurvey == null) {
            System.out.println("Must create a survey before saving it");
            return;
        }

        if (currentSurvey.questions.isEmpty()) {
            System.out.println("Cannot save empty survey");
            return;
        }

        File directory = new File("surveys\\" + currentSurvey.name);
        directory.mkdir();

        String path = "surveys\\" + currentSurvey.name + "\\" + currentSurvey.name + ".txt";
        serialize(path, currentSurvey);

        displaySurvey(currentSurvey);
    }

    public static void takeSurvey(Survey currentSurvey) {
        if (currentSurvey == null) {
            System.out.println("Must load or create a survey before taking it");
            return;
        }

        if (currentSurvey.name.isEmpty()) {
            System.out.println("You must save the survey before taking it");
            return;
        }

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
        if (currentSurvey == null) {
            System.out.println("Must load or create a survey before modifying it");
            return;
        }

        displaySurvey(currentSurvey);

        while (true) {
            System.out.print("Which question do you want to modify? Please enter a number starting from 1: ");
            Scanner scanner = new Scanner(System.in);
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index >= 0 && index < currentSurvey.questions.size()) {
                    currentSurvey.questions.get(index).modify();
                    break;
                } else {
                    System.out.println("Number out of range");
                }
            } catch (Exception e) {
                System.out.println("Invalid question number");
            }
        }

        saveSurvey(currentSurvey);
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
        Survey survey = new Survey();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            survey = (Survey) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return survey;
    }
}
