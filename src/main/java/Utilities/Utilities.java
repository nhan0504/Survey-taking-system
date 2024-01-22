package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public static boolean checkNumberInRange(String input, int low, int high) {
        try {
            int number = Integer.parseInt(input);
            if (number >= low && number < high) {
                return true;
            } else {
                System.out.println("Number out of range");
            }
        } catch (Exception e) {
            System.out.println("Please enter a number");
        }
        return false;
    }

    public static boolean validFileName(String fileName) {
        Pattern pattern = Pattern.compile("[\\\\/:*?\"<>|&]");
        Matcher matcher = pattern.matcher(fileName);

        if (fileName.trim().isEmpty()) {
            System.out.println("Name cannot be empty");
            return false;
        }

        if (matcher.find()) {
            System.out.println("Contains invalid characters");
            return false;
        }

        for (char c : fileName.toCharArray()) {
            if (c < 32) {
                System.out.println("Contains control characters");
                return false;
            }
        }

        return true;
    }
}
