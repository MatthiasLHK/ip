public class AddDeadlineCommand extends Command {
    public static void execute(String input) throws ErrorExceptions {
        String name = InputManager.getName(input, 2);
        String date = InputManager.getDate(input,1);
        TaskManager.newTask(name,"Deadline",date, InputManager.getFileDir());
    }
}
