import java.util.NoSuchElementException;
import java.util.Scanner;

public class checker {
    public static int inputChecker(String echo) {
        int isDone = 0;
        Scanner sc = new Scanner(echo);
        String first = sc.next();
        if(first.equals("done")){
            try{
                String index = sc.next();
                try{
                    int I = Integer.parseInt(index);
                    isDone = I;
                }
                catch(NumberFormatException e){ // next word is not an integer
//                    System.out.println("Error 2: Not a complete 'Done' command, added as a task!");
                }
            }
            catch(NoSuchElementException e){
//                System.out.println("Error 1: Not a complete 'Done' command, added as a task!");
            }
        }
        return isDone;
    }

    public static int typeChecker(String echo){
        Scanner sc = new Scanner(echo);
        String E = sc.next();
        if(E.equals("todo")){
            return 1;
        }
        else if(E.equals("deadline")){
            return 2;
        }
        else if(E.equals("event")){ // Events
            return 3;
        }
        else{ // no types indicated
            return 4;
        }
    }

    public static String name(String echo){
        Scanner sc = new Scanner(echo);
        sc.next();
        String curr = sc.next();
        String C = "" + curr.charAt(0);
        String N = "";
        try{
            while(!C.equals("/")){
                N = N + curr + " ";
                curr = sc.next();
                C = "" + curr.charAt(0);
            }
        }
        catch(NoSuchElementException e){

        }
        return N;
    }

    public static String dateFinder(String echo, int type){
        Scanner sc = new Scanner(echo);
        String next = sc.next();
        String N = "" + next.charAt(0);
        String date = "";
        try{
            while(!N.equals("/")){
                next = sc.next();
                N = "" + next.charAt(0);
            }
            int length = next.length();
            String action = "";
            for(int i=1; i<length; i++){
                action = action + next.charAt(i);
            }
            action = "(" + action + ": ";
            try{
                String day = sc.next();
                try{
                    String time = sc.next();
                    action = action + day + " " + time + ")";
                }
                catch(NoSuchElementException e){
                    action = action + day + ")";
                }
                date = action;
            }
            catch(NoSuchElementException e){
                if(type == 2){
                    return date;
                }
                else{
//                    System.out.println("Wrong command format, missing date");
                }
            }
        }
        catch(NoSuchElementException e){
            if(type == 1){
                return date;
            }
            else{
//                System.out.println("Wrong command format, missing /action: date");
            }
        }
        return date;
    }
}
