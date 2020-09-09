package Tasks;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DateTime.DateTimeManager;
import Errors.ErrorExceptions;
import File.FileManager;
import UI.UserInterface;




/**
 * Represents the object that handles all the actions carried out by the task.
 */
public class TaskManager {
    private static ArrayList<task> store = new ArrayList<>();
    private static String fileDir;

    /**
     * Creates and returns a new task depending on the type of task entered by the user.
     *
     * @param name name of task.
     * @param itype type of task.
     * @param date due date.
     * @param fileDir file directory of the local save.
     * @return String the added task message.
     * @throws ErrorExceptions if there is an error adding the date.
     */
    public static String newTask2(String name, String itype, String date, String fileDir) throws ErrorExceptions {
        task Task;
        if (itype.equals("Todo")) {
            Task = new Todo(name, "[T]");
        } else if (itype.equals("Deadline")) {
            Task = new Deadline(name, "[D]");
            DateTimeManager.addDate(Task, date);
        } else {
            Task = new Event(name, "[E]");
            DateTimeManager.addDate(Task, date);
        }
        store.add(Task);
        save(fileDir, Task);
        return UserInterface.addedTask2(Task);
    }

    /**
     * Returns the selected task from the task store ArrayList.
     *
     * @param index index of the task.
     * @return task selected task.
     */
    public static task getTask(int index) {
        task t = store.get(index - 1);
        return t;
    }

    /**
     * Sets the task to be completed.
     *
     * @param t task.
     */
    public static void completed(task t) {
        t.setDone();
        try {
            FileManager.edit(fileDir, store);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes the selected task from the list.
     *
     * @param index index of the task.
     */
    public static void delete(int index) {
        store.remove(index - 1);
        try {
            FileManager.edit(fileDir, store);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns the number of tasks stored in the ArrayList.
     *
     * @return int number of tasks.
     */
    public static int storeIndex() {
        return store.size();
    }

    /**
     * Returns the printing String of a task which contain all the information.
     *
     * @param t task.
     * @return String message.
     */
    public static String read(task t) {
        String done = "";
        if (t.getTaskCompleted()) {
            done = "[O]";
        } else {
            done = "[X]";
        }
        if (t.getTaskType().equals("[T]")) {
            return t.getTaskType() + done + " " + t.getTaskName();
        } else if (t.getTaskType().equals("[D]")) {
            return t.getTaskType() + done + " " + t.getTaskName() + "(by: "
                    + t.getTaskDate().format(DateTimeFormatter.ofPattern("dd MMM uuuu HHmm")) + ")";
        } else {
            return t.getTaskType() + done + " " + t.getTaskName() + "(at: "
                    + t.getTaskDate().format(DateTimeFormatter.ofPattern("dd MMM uuuu HHmm")) + ")";
        }
    }

    /**
     * Returns the lists all the tasks that is currently in
     * the list and all its relevant information.
     *
     * @return String list of tasks.
     */
    public static String listing2() {
        String result = "";
        result = result + "These are your current tasks!";
        int count = 1;
        for (task i : store) {
            result = result + System.lineSeparator();
            result = result + count + ". " + read(i);
            count++;
        }
        return result;
    }

    /**
     * Loads the local save file into the program to continue the previous list.
     * @param save
     */
    public static void load(File save) {
        FileManager.read(save, store);
    }

    /**
     * Calls the FileManager to save the selected task into the local save file.
     * @param fileDir file directory of the local save.
     * @param t task.
     */
    public static void save(String fileDir, task t) {
        try {
            FileManager.add(fileDir, TaskManager.read(t));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Sets the file directory of the local save file.
     *
     * @param d file file directory.
     */
    public static void fileDir(String d) {
        fileDir = d;
    }

    /**
     * Clones and returns the ArrayList the stores all the tasks.
     *
     * @return ArrayList task store.
     *
     */
    public static ArrayList<task> getStore() {
        ArrayList<task> clone = new ArrayList<>();
        for (task i : store) {
            clone.add(i);
        }
        return clone;
    }
}
