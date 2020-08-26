public class AddEventCommand extends Command {
    public static void execute(String input) throws ErrorExceptions {
        String name = InputManager.getName(input, 2);
        String date = InputManager.getDate(input,2);
        TaskManager.newTask(name,"Event",date, InputManager.getFileDir());
    }
}
