import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import Parser.InputManager;
import Tasks.TaskManager;
import UI.UserInterface;
import javafx.application.Platform;

/**
 * Represents the main method of the MattBot program. The bot is able to track added todo tasks into the list and it
 * is stored locally in a save txt file called DukeTodoSave.txt located in the root of the project directory.
 * If this file is not present, the program will automatically create this text file in the root.
 */
public class Duke {
    public static Stream<String> convertToStream(String input) {
        Scanner sc = new Scanner(input);
        ArrayList<String> comboCommands = new ArrayList<>();
        String sum = "";
        while (sc.hasNext()) {
            String current = sc.next();
            if (gotComma(current)) {
                current = current.substring(0, current.length() - 1);
                sum += current + " ";
                comboCommands.add(sum);
                sum = "";
            } else {
                sum += current + " ";
            }
        }
        comboCommands.add(sum);
//        System.out.println(comboCommands);
        Stream<String> comboCommandStream = comboCommands.stream();
        return comboCommandStream;
    }

    private static boolean gotComma(String word) {
        int lengthOfCurrent = word.length();
        boolean haveComma = false;
        if (word.charAt(lengthOfCurrent - 1) == ',') {
            haveComma = true;
        }
        return haveComma;
    }
    static String removeBlank(String input) {
        String userInput = "";
        int length = input.length();
        if (input.charAt(length-1) == ' ') {
            userInput = input.substring(0, input.length() - 1);
        } else {
            userInput = input;
        }
        return userInput;
    }
    static String getResponse(String input) {
        String userInput = removeBlank(input);
        System.out.println("CHANGED: " + userInput);
        UserInterface UI = new UserInterface();
        UI.input(userInput);
        if (input.equals("bye")) {
            Platform.exit();
        }
        return UI.parse2();
    }
    /**
     * Represents the main method of the program. The start of the mattbot program.
     * @param args args.
     */
    public static void main(String[] args) {
        String fileDir = "./DukeTodoSave.txt";
        InputManager.fileDir(fileDir);
        File save = new File(fileDir);
        if (!save.exists()) { // create the text file
            System.out.println("Save file does not exist, creating it now!");
            try {
                save.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating the save file!");
                System.out.println(e);
            }
        }
        TaskManager.load(save);
        Scanner sc = new Scanner(System.in);
        UserInterface UI = new UserInterface();
        while (UI.getStop() == false) {
            UI.input(sc.nextLine());
            UI.parse();
        }
        sc.close();
    }
}
