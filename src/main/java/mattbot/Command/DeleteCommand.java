package mattbot.Command;

import java.util.NoSuchElementException;

import mattbot.Errors.ErrorExceptions;
import mattbot.Tasks.TaskManager;
import mattbot.Tasks.task;
import mattbot.UI.UserInterface;

/**
 * Represents a command that deletes a task.
 */
public class DeleteCommand extends Command {

    /**
     * Deletes the selected task from the list.
     * Returns the deleted task message.
     *
     * @param i task index.
     * @throws ErrorExceptions failed to find task.
     */
    public static String execute2(int i) throws ErrorExceptions {
        task t;
        int index = i;
        try {
            t = TaskManager.getTask(index);
            TaskManager.delete(index);
            UserInterface.done2();
            return "    " + TaskManager.read(t) + System.lineSeparator()
                    + "The tracked Tasks.task has been deleted!";
        } catch (NoSuchElementException e) {
            throw new ErrorExceptions("There is no suck Tasks.task!");
        }
    }
}
