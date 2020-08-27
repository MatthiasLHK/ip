package Command;

import Errors.ErrorExceptions;
import Tasks.TaskManager;
import Tasks.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a command that filters the task by the date.
 */
public class FilterDateCommand extends Command {
    /**
     * Filters the tasks based on the input date, showing only those with that date.
     *
     * @param date date to search.
     * @throws ErrorExceptions wrong date format.
     */
    public static void execute(LocalDate date) throws ErrorExceptions {
        System.out.println("Filtered called");
        ArrayList<task> clone = TaskManager.getStore();
        int count = 1;
        System.out.println("Here are your tasks on this date!");
        for(task i : clone){
            if(i.getTaskDate()!=null){
                if(i.getTaskDate().toLocalDate().equals(date)){
                    System.out.println("    " + count + ". " + TaskManager.read(i));
                    count++;
                }
            }
        }

    }
}
