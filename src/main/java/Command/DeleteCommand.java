package Command;

import java.util.NoSuchElementException;

import Errors.ErrorExceptions;
import Tasks.TaskManager;
import Tasks.task;
import UI.UserInterface;

/**
 * Represents a command that deletes a task.
 */
public class DeleteCommand extends Command {

    /**
     * Deletes the selected task from the list.
     *
     * @param i task index.
     * @throws ErrorExceptions failed to find task.
     */
    public static void execute(int i) throws ErrorExceptions {
        task t;
        int index = i;
        try {
            t = TaskManager.getTask(index);
            TaskManager.delete(index);
            UserInterface.done();
            System.out.println("    " + TaskManager.read(t));
            System.out.println("The tracked Tasks.task has been deleted!");
        } catch (NoSuchElementException e) {
            throw new ErrorExceptions("There is no suck Tasks.task!");
        }
    }

    public static String execute2(int i) throws ErrorExceptions {
        task t;
        int index = i;
        try {
            t = TaskManager.getTask(index);
            TaskManager.delete(index);
            UserInterface.done();
            return "    " + TaskManager.read(t) + System.lineSeparator()
                    + "The tracked Tasks.task has been deleted!";
        } catch (NoSuchElementException e) {
            throw new ErrorExceptions("There is no suck Tasks.task!");
        }
    }
}
