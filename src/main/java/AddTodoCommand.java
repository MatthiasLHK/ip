
public class AddTodoCommand extends Command {
    public static void execute(String input) throws ErrorExceptions {
        String name = InputManager.getName(input, 1);
        TaskManager.newTask(name,"Todo",null, InputManager.getFileDir());
    }
}
