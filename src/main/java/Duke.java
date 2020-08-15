import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        ArrayList<task> store = new ArrayList<>();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String echo = sc.nextLine();
        int count = 1;
        int index = checker.inputChecker(echo);

        while(echo.equals("bye") == false){
            if(echo.equals("list")){
                for(task i : store){
                    System.out.println(i.read());
                }
            }
            else if(index!=0){
                try{
                    task l = store.get(index-1);
                    l.done();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("  " + l.read2());
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("There is no such task!");
                }
            }
            else{
                task temp = new task(echo);
                System.out.println("added: " +echo);
                store.add(temp);
                count++;
            }
            echo = sc.nextLine();
            index = checker.inputChecker(echo);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
