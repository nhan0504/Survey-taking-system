package Questionaire;

import Question.Question;
import Question.QuestionFactory;
import Utilities.Utilities;

import java.io.*;
import java.util.*;

public abstract class Questionnaire implements Serializable {
    String name;
    List<Question> questions;
    List<HashMap<String, Integer>> tabulate;

    protected Questionnaire() {
        this.name = "";
        this.questions = new ArrayList<>();
        this.tabulate = new ArrayList<>();
    }

    public void display() {
        if (this.questions.isEmpty()) {
            System.out.println("Cannot display empty");
            return;
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Start-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();
        int index = 1;
        for (Question question : this.questions) {
            System.out.print(index++ + ". ");
            question.display();
            System.out.println();
        }
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-End-~--~-~-~-~-~-~-~-~-~-~-~-~-~");
    }

    public void modify() {
        if (this.questions.isEmpty()) {
            System.out.println("Cannot modify empty");
            return;
        }

        this.display();

        while (true) {
            System.out.print("Which question do you want to modify? Please enter a number starting from 1: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, this.questions.size() + 1)) {
                this.questions.get(Integer.parseInt(input) - 1).modify();
                break;
            }
        }

        System.out.println("Choose save if you want to save the recent changes");
    }

    public void save(String saveDirectory) {
        if (this.questions.isEmpty()) {
            System.out.println("Cannot save empty");
            return;
        }

        File directory = new File(saveDirectory + "\\" + this.name);
        directory.mkdir();

        String path = saveDirectory + "\\" + this.name + "\\" + this.name + ".txt";
        Utilities.serialize(path, this);

        this.display();
    }

    public void take(String saveDirectory) {
        File surveyDirectory = new File(saveDirectory + "\\" + this.name);
        if (!surveyDirectory.exists()) {
            System.out.println("You must save before taking");
            return;
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Start-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();


        for(int i = 0; i < questions.size(); i++) {
            int displayIndex = i + 1;
            System.out.print(displayIndex + ". ");
            questions.get(i).display();

            List<String> answers = questions.get(i).getAnswer();

            HashMap<String, Integer> questionTabulate = tabulate.get(i);
            for (String answer : answers) {
                questionTabulate.put(answer, questionTabulate.getOrDefault(answer, 0) + 1);
            }

            System.out.println();
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-End~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();

        this.saveAnswer(saveDirectory);
        this.save(saveDirectory);
    }

    public static <T extends Questionnaire> T load(Class<T> type, String saveDirectory) {
        Scanner scanner = new Scanner(System.in);
        String path;

        List<String> allItems = Utilities.getFolderItemName(saveDirectory);
        if (allItems.isEmpty()) {
            System.out.println("Nothing to load");
            return null;
        }
        Utilities.display(allItems);

        while(true) {
            System.out.print("Which do you want to load? Enter a number: ");
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, allItems.size() + 1)) {
                int index = Integer.parseInt(input) - 1;
                path = saveDirectory + "\\" + allItems.get(index) + "\\" + allItems.get(index) + ".txt";
                break;
            }
        }

        return Utilities.deserialize(path, type);
    }

    public void tabulate() {
        if (this.questions.isEmpty()) {
            System.out.println("Cannot tabulate empty");
            return;
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Start-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();
        for (int i = 0; i < questions.size(); i++) {
            int displayIndex = i + 1;
            System.out.print(displayIndex + ". ");
            questions.get(i).display();

            System.out.println("Tabulation:");
            HashMap<String , Integer> map = tabulate.get(i);
            questions.get(i).tabulate(map);
            System.out.println();
        }
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-End-~--~-~-~-~-~-~-~-~-~-~-~-~-~");
    }

    public Question addTF() {
        Question question = QuestionFactory.createTrueFalse();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    public Question addMultipleChoice() {
        Question question = QuestionFactory.createMultipleChoice();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    public Question addShortAnswer() {
        Question question = QuestionFactory.createShortAnswer();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    public Question addEssay() {
        Question question = QuestionFactory.createEssay();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    public Question addDate() {
        Question question = QuestionFactory.createDate();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    public Question addMatching() {
        Question question = QuestionFactory.createMatching();
        this.questions.add(question);
        this.tabulate.add(new HashMap<>());
        return question;
    }

    private void saveAnswer(String saveDirectory) {
        while (true) {
            String name = getFileName("your");
            String path = saveDirectory + "\\" + this.name + "\\" + name + ".txt";
            File file = new File(path);
            if (!file.exists()) {
                Utilities.serialize(path, this);
                break;
            } else {
                System.out.println("Name already exists");
            }
        }
    }
    protected static String getFileName(String nameType) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter " +nameType + " name: ");
            String name = scanner.nextLine();

            if (Utilities.validFileName(name)) {
                return name;
            }
        }
    }
}
