public class Event extends task{
    private String type = "[E]";
    private String date;

    public Event(String name){
        super(name);
        System.out.println("Got it. I've added this task: ");
        System.out.println("  " + this.type + "[X]" + " " + this.name);
        System.out.println("Now you have" + count + " tasks in the list.");
    }

    public void addDate(String date){
        this.date = date;
    }

    public String read(){
        String done = "";
        if(super.completed){
            done = "[✓]";
        }
        else{
            done = "[X]";
        }
        return this.index + ". " + this.type + done + " " + this.name + this.date;
    }

    public String read2(){
        String done = "";
        if(this.completed){
            done = "[✓]";
        }
        else{
            done = "[X]";
        }
        return this.type + done + " " + this.name;
    }
}
