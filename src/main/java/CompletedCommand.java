public class CompletedCommand extends Command{
    public static void execute(int i) throws ErrorExceptions {
        task t;
        int index = i;
        try {
            t = TaskManager.getTask(index);
            TaskManager.completed(t);
            UserInterface.done();
            System.out.println("    " + TaskManager.read(t));
            System.out.println("The tracked task has been marked as completed! Congrats~~!");
        } catch(IndexOutOfBoundsException e){
            throw new ErrorExceptions("There is no such task!");
        }
    }
}
