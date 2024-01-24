package Question;

import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matching extends Question{
    int maxValueLength = 30;
    public List<List<String>> columns;

    public Matching(String question) {
        super(question);
        this.columns = new ArrayList<>();
        columns.add(new ArrayList<>());
        columns.add(new ArrayList<>());
    }

    @Override
    public void display() {
        System.out.println(this.question + " Enter your answer in the format A-1");
        char index1 = 'A';
        int index2 = 1;
        int numSpace = maxValueLength + 3;
        for (int i = 0; i < columns.get(0).size(); i++) {
            System.out.print(index1++ + ". " + columns.get(0).get(i));
            for (int s = 0; s < numSpace - columns.get(0).get(i).length(); s++) {
                System.out.print(" ");
            }
            System.out.println(index2++ + ") " + columns.get(1).get(i));
        }
    }

    public void getOptions() {
        Scanner scanner = new Scanner(System.in);

        int maxNumOption = 10;
        int numValue = 0;

        while (true) {
            System.out.print("How many value do you want to add in each column? Must be less than " + maxNumOption + ": ");
            String input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, 1, maxNumOption)) {
                numValue = Integer.parseInt(input);
                break;
            }
        }

        for (int i = 0; i < columns.size(); i++) {
            getValueForColumn(i, numValue);
        }
    }

    private void getValueForColumn(int column, int numValue) {
        Scanner scanner = new Scanner(System.in);
        int numberDisplay = column + 1;
        System.out.println("Enter value for column " + numberDisplay);

        for (int i = 0; i < numValue; i++) {
            int index = i + 1;

            while (true) {
                System.out.print("Enter value " + index + ": ");
                String value = scanner.nextLine();

                if (isValidValue(value)) {
                    this.columns.get(column).add(value);
                    break;
                } else {
                    System.out.println("Value too long");
                }
            }
        }
    }

    private boolean isValidValue(String value) {
        return value.length() < maxValueLength;
    }

    @Override
//    public void getAnswer() {
//        Scanner scanner = new Scanner(System.in);
//        String answer;
//        for (int i = 0; i < columns.get(0).size(); i++) {
//            int numberDisplay = i + 1;
//            while (true) {
//                System.out.print("Enter answer " + numberDisplay + ": ");
//                answer = scanner.nextLine();
//                if (isValidAnswer(answer)) {
//                    break;
//                } else {
//                    System.out.println("Answer is invalid");
//                }
//            }
//            this.answers.add(answer);
//        }
//    }

    public boolean isValidAnswer(String answer) {
        int size = columns.get(0).size();
        String regex = "^[A-" + (char)('A' + size - 1) + "]\\-[1-" + size + "]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);
        return matcher.matches();
    }

    @Override
    public void modify() {
        Scanner scanner = new Scanner(System.in);

        TrueFalse modifyPrompt = new TrueFalse("Do you want to modify the question prompt? ");
        modifyPrompt.display();
        modifyPrompt.getAnswer();
        if (modifyPrompt.answers.get(0).equals("yes")) {
            System.out.print("Enter new prompt for question: ");
            this.question = scanner.nextLine();
        }

        for (int i = 0; i < columns.size(); i++) {
            int numberDisplay = i + 1;
            TrueFalse modifyColumn = new TrueFalse("Do you want to modify column " + numberDisplay + " values?");
            modifyColumn.display();
            modifyColumn.getAnswer();

            if (modifyColumn.answers.get(0).equals("yes")) {
                while (true) {
                    System.out.print("Which value do you want to modify? Enter a number starting from 1 ");
                    String input = scanner.nextLine();
                    if (Utilities.checkNumberInRange(input, 1, this.columns.get(i).size() + 1)) {
                        int index = Integer.parseInt(input);
                        System.out.print("Enter new value for value " + index + ": ");
                        this.columns.get(i).set(index - 1, scanner.nextLine());
                        break;
                    }
                }
            }
        }
    }
}
