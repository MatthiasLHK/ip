package UI;

import Tasks.TaskManager;
import Tasks.task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Represents a UserInterface that is used by the main program. The UserInterface class handles all
 * the inputs entered by the user. It also helps to check for empty commands and prints most of the
 * replies from the bot.
 */
public class UserInterface {
    private static boolean isExit = false;
    private String input;
    private Stream<String> inputStream;

    /**
     * Creates a UserInterface object that helps to handle all the user inputs and pass it along to
     * the parser to be broken down.
     */
    public UserInterface() {
        System.out.println("Welcome to MattBot v1.0!" + System.lineSeparator()
                        + "How may I assist you today?");
    }

    /**
     * Saves the user input in the instance variable.
     *
     * @param input
     */
    public void input(String input) {
        this.input = input;
    }


    /**
     * Calls the Parser and pass the user input along to be broken down and understood.
     */
    private void action() {
        InitiateParser.parser(input);
    }

    /**
     * Prints the error message when an empty command is entered into the bot.
     */
    private void failed() {
        System.out.println("No commands entered, please enter a command!");
    }

    /**
     * Determines if the user input is acceptable, whether it is null or not.
     * If the input is null, failed() is called.
     * If the input is not null, action() is called.
     */
    public void parse() {
        if (this.input.equals("")) {
            failed();
        } else {
            action();
        }
    }

    /**
     * Prints the closing off statement when the user shuts down the Mattbot.
     */
    public static void stop() {
        isExit = true;
        System.out.println("Awww, leaving so soon? Hope to see you again!");
    }

    /**
     * Prints the task processing message when the user tries to mark a task as completed.
     */
    public static void done() {
        System.out.println("Beep Boop Beep .....");
    }

    /**
     * Returns the value of the exit variable of the instance. This determines if the user entered the exit
     * command.
     *
     * @return boolean whether the user entered the exit command.
     */
    public boolean getStop() {
        return isExit;
    }

    /**
     * Prints the error message when an invalid command is entered by the user.
     */
    public static void wrongCommand() {
        System.out.println("Errroorrrr! Invalid command entered! Cannot compute!");
    }

    /**
     * Prints the message when a task is successfully added into the list.
     *
     * @param t the selected task to be added.
     */
    public static void addedTask(task t) {
        System.out.println("Task has been successfully added!");
        System.out.println("    " + TaskManager.read(t));
        System.out.println("MattBot is tracking " + TaskManager.storeIndex() + " number of Tasks.task!");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String welcomeMessage(){
        return "Welcome to MattBot v1.0!" + System.lineSeparator()
                + "How may I assist you today?";
    }

    private String failed2() {
        return "No commands entered, please enter a command!";
    }

    private String action2(String command) {
        return InitiateParser.parser2(command);
    }

    public String parse2() {
        if (this.input.equals("")) {
            return failed2();
        } else {
            return action2(input);
        }
    }

    public static String stop2() {
        isExit = true;
        return "Awww, leaving so soon? Hope to see you again!";
    }

    public static String wrongCommand2() {
        return "Errroorrrr! Invalid command entered! Cannot compute!";
    }

    public static String addedTask2(task t) {
        String result = "";
        String nLine = System.lineSeparator();
        String one = "Task has been successfully added!";
        String two = "    " + TaskManager.read(t);
        String three = "MattBot is tracking " + TaskManager.storeIndex() + " number of Tasks.task!";
        result = result + one + nLine + two + nLine + three;
        return result;
    }
}
