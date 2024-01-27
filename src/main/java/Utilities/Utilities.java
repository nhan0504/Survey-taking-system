package Utilities;

import java.io.*;
import java.util.*;
import java.util.regex.*;

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

    public static <T> void serialize(String path, T object) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(object);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    public static <T> T deserialize(String path, Class<T> type) {
        T object = null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            object = type.cast(inputStream.readObject());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return object;
    }

    public static List<String> getFolderItemName(String path) {
        File folder = new File(path);
        return new ArrayList<>(Arrays.asList(folder.list())) ;
    }

    public static void display(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int displayIndex = i + 1;
            System.out.println(displayIndex + ". " + list.get(i));
        }
    }

    public static int getOption(String message, int low, int high) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine();
            if (Utilities.checkNumberInRange(input, low, high)) {
                return Integer.parseInt(input);
            }
        }
    }
}
