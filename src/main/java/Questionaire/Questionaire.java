package Questionaire;

import Question.Question;
import Utilities.Utilities;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public abstract class Questionaire implements Serializable {
    String name;
    String saveDirectory;
    List<Question> questions;

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

        //Save after modify
    }

    public void save() {
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

    public void take() {
        File surveyDirectory = new File(saveDirectory + "\\" + this.name);
        if (!surveyDirectory.exists()) {
            System.out.println("You must save before taking");
            return;
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~Start-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();

        int displayIndex = 1;
        for(Question question : this.questions) {
            System.out.print(displayIndex++ + ". ");
            question.display();
            question.getAnswer();
            System.out.println();
        }

        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-End~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println();

        this.saveAnswer();
    }

    private void saveAnswer() {
        while (true) {
            String name = getFileName("your");
            String path = "surveys\\" + this.name + "\\" + name + ".txt";
            File file = new File(path);
            if (!file.exists()) {
                Utilities.serialize(path, this);
                break;
            } else {
                System.out.println("Name already exists");
            }
        }
    }

    //public abstract Questionaire load();

    public abstract void tabulate();


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
