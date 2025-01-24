import java.util.ArrayList;
import java.util.Scanner;

public class Orim {
    public static void main(String[] args) {
        String LINE  = "____________________________________________________________\n";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        ArrayList<Task> taskList = new ArrayList<Task>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello from\n" + logo);
        System.out.println(LINE + "Hello! I'm Orim.\n" + "What can I do for you?\n" + LINE);
        while (sc.hasNext()) {
            String cmd = sc.next();
            System.out.println(LINE);
            switch (cmd) {
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!\n" + LINE);
                    System.exit(0);
                case "list":
                    System.out.println("\nHere are the tasks in your list:\n");
                    for (int i = 1; i < taskList.size() + 1; i++) {
                        System.out.println(i + "." + taskList.get(i - 1) + "\n");
                    }
                    break;
                case "mark":
                    taskList.get(sc.nextInt()).mark();
                    break;
                case "unmark":
                    taskList.get(sc.nextInt()).unmark();
                    break;
                case "todo":
                    Todo tempT = new Todo(sc.nextLine().trim());
                    taskList.add(tempT);
                    System.out.println("Got it. I've added this task:\n " + tempT.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                case "deadline":
                    String dStr = sc.nextLine();
                    Deadline tempD = new Deadline(dStr.split("/by")[0].trim(),
                            dStr.split("/by")[1].trim());
                    taskList.add(tempD);
                    System.out.println("Got it. I've added this task:\n " + tempD.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                case "event":
                    String eStr = sc.nextLine();
                    Event tempE = new Event(eStr.split("/from")[0].trim(),
                            eStr.split("/from")[1].split("/to")[0].trim(),
                            eStr.split("/from")[1].split("/to")[1].trim());
                    taskList.add(tempE);
                    System.out.println("Got it. I've added this task:\n " + tempE.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
            }
            System.out.println(LINE);
        }
    }
}
