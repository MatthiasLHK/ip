import java.util.NoSuchElementException;

public class DeleteCommand extends Command {
    public static void execute(int i) throws ErrorExceptions {
        task t;
        int index = i;
        try {
            t = TaskManager.getTask(index);
            TaskManager.delete(index);
            UserInterface.done();
            System.out.println("    " + TaskManager.read(t));
            System.out.println("The tracked task has been deleted!");
        } catch(NoSuchElementException e){
            throw new ErrorExceptions("There is no suck task!");
        }
    }
}
