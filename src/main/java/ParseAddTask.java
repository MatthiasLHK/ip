public class ParseAddTask extends Parse{
    public static void execute(String s, String input) throws ErrorExceptions{
        String current = s;
        if(current.equals("todo")) {
            AddTodoCommand.execute(input);
        } else if(current.equals("deadline")){
            AddDeadlineCommand.execute(input);
        } else if(current.equals("event")){
            AddEventCommand.execute(input);
        } else{
            WrongCommand.execute();
        }
    }
}
