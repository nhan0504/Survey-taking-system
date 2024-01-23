package Questionaire;

import Question.Question;
import Utilities.Utilities;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public abstract class Questionaire implements Serializable {
    String name;
    List<Question> questions;

    public abstract void create();

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

    public abstract void modify();

    public abstract void save();

    public abstract void take();

    public abstract void load();

    public abstract void tabulate();


    protected static String getName(String questionaireType) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter " + questionaireType + " name: ");
            String name = scanner.nextLine();

            if (Utilities.validFileName(name)) {
                return name;
            }
        }
    }
}
