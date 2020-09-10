package Parser;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Errors.ErrorExceptions;
import Tasks.TaskManager;
import Tasks.task;



/**
 * Represents a manager that handles all actions carried out by the parser.
 * Decomposes all user input into key terms.
 */
public class InputManager {
    private static String fileDir;

    /**
     * Determines what bridge Parse to call based on the user input.
     *
     * @param input user input.
     * @throws ErrorExceptions when selected task do not exists.
     */
    public static void parse(String input) throws ErrorExceptions {
        assert input.equals("") == false;
        Scanner sc = new Scanner(input);
        String current = sc.next();
        TaskManager.fileDir(fileDir);
        if (current.equals("bye")) {
            ParseExit.execute();
        } else if (current.equals("delete")) {
            try {
                int index = sc.nextInt();
                assert index >= 0;
                ParseDelete.execute(index);
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("There is no such tasks!");
            }
        } else if (current.equals("done")) {
            try {
                task t;
                int index = sc.nextInt();
                assert index >= 0;
                ParseCompleted.execute(index);
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("There is no such tasks!");
            }
        } else if (current.equals("list")) {
            ParseList.execute();
        } else if (current.equals("show")) {
            ParseShow.execute();
        } else if (current.equals("filter")) {
            try {
                String date = sc.next();
                ParseFilter.execute(date);
                assert date.equals("") == false;
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("Missing date!");
            }
        } else if (current.equals("find")) {
            try {
                assert input.equals("") == false;
                ParseFind.execute(input);
            } catch (ErrorExceptions e) {
                System.out.println(e);
            }
        } else { // add tasks
            assert current.equals("") == false;
            assert input.equals("") == false;
            ParseAddTask.execute(current, input);
        }
    }

    /**
     * Returns the name of the task from the user input.
     *
     * @param input user input.
     * @param type type of task.
     * @return String name of task.
     * @throws ErrorExceptions when the add task command format is wrong
     */
    public static String getName(String input, int type) throws ErrorExceptions {
        Scanner sc = new Scanner(input);
        sc.next(); // skip first commandtype
        String name = "";
        try {
            String current = sc.next();
            if (type == 1) { // todo
                try {
                    while (current.charAt(0) != '/') { // deadline and event
                        name = name + current + " ";
                        current = sc.next();
                    }
                } catch (NoSuchElementException e) {
                    // do nothing
                }
            } else {
                try {
                    while (current.charAt(0) != '/') { // deadline and event
                        name = name + current + " ";
                        current = sc.next();
                    }
                } catch (NoSuchElementException e) {
                    // do nothing
                }
            }
            return name;
        } catch (NoSuchElementException e) {
            throw new ErrorExceptions("Missing item name!");
        }
    }

    /**
     * Returns the LocalDateTime from the user input.
     *
     * @param input user input.
     * @param type type of task.
     * @return LocalDateTime date and time.
     * @throws ErrorExceptions when the date and time format is wrong or missing.
     */
    public static String getDate(String input, int type) throws ErrorExceptions {
        Scanner sc = new Scanner(input);
        String next = sc.next();
        String N = "" + next.charAt(0);
        String date = "";
        try {
            while (!N.equals("/")) {
                next = sc.next();
                N = "" + next.charAt(0);
            }
            String action = "";
            try {
                String day = sc.next();
                action = action + day;
                try {
                    String time = sc.next();
                    action = action + " " + time;
                } catch (NoSuchElementException e) {
                    if (type == 2) {
                    } else {
                        throw new ErrorExceptions("Wrong event command format, missing timeslot");
                    }
                }
                date = action;
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("Wrong event command format, missing date");
            }
        } catch (NoSuchElementException e) {
            if (type == 1) {
                return date;
            } else {
                throw new ErrorExceptions("Wrong deadline or event command format, missing /action: task");
            }
        }
        return date;
    }

    /**
     * Sets the file directory of the local save.
     *
     * @param d file directory.
     */
    public static void fileDir(String d) {
        fileDir = d;
    }

    /**
     * Returns the file directory of the local save.
     *
     * @return String file directory.
     */
    public static String getFileDir() {
        return fileDir;
    }

    public static String parse2(String input) throws ErrorExceptions {
        Scanner sc = new Scanner(input);
        String current = sc.next();
        TaskManager.fileDir(fileDir);
        if (current.equals("bye")) {
            return ParseExit.execute2();
        } else if (current.equals("delete")) {
            try {
                int index = sc.nextInt();
                return ParseDelete.execute2(index);
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("There is no such tasks!");
            }
        } else if (current.equals("done")) {
            try {
                task t;
                int index = sc.nextInt();
                return ParseCompleted.execute2(index);
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("There is no such tasks!");
            }
        } else if (current.equals("list")) {
            return ParseList.execute2();
        } else if (current.equals("show")) {
            return ParseShow.execute2();
        } else if (current.equals("filter")) {
            try {
                String date = sc.next();
                return ParseFilter.execute2(date);
            } catch (NoSuchElementException e) {
                throw new ErrorExceptions("Missing date!");
            }
        } else if (current.equals("find")) {
            try {
                return ParseFind.execute2(input);
            } catch (ErrorExceptions e) {
                return e.toString();
            }
        } else { // add tasks
            return ParseAddTask.execute2(current, input);
        }
    }
}
