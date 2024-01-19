package Utilities;

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
}
