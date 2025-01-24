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
        Task[] taskList = new Task[101];
        int numOfTask = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello from\n" + logo);
        System.out.println(LINE + "Hello! I'm Orim.\n" + "What can I do for you?\n" + LINE);
        while (sc.hasNext()) {
            String tempString = sc.nextLine();
            if (tempString.equals("bye")) {
                System.out.println(LINE + "Bye. Hope to see you again soon!\n" + LINE);
                System.exit(0);
            }
            if (tempString.equals("list")) {
                System.out.println(LINE + "\nHere are the tasks in your list:\n");
                for (int i = 1; i < numOfTask; i++) {
                    Task curTask = taskList[i];
                    System.out.println(i + ".[" + curTask.getStatusIcon() +
                            "] " + curTask + "\n");
                }
                System.out.println(LINE);
                continue;
            }
            if (tempString.split(" ")[0].equals("mark")) {
                System.out.println(LINE);
                int tempNum = Integer.parseInt(tempString.split(" ")[1]);
                taskList[tempNum].mark();
                System.out.println(LINE);
                continue;
            }
            if (tempString.split(" ")[0].equals("unmark")) {
                System.out.println(LINE);
                int tempNum = Integer.parseInt(tempString.split(" ")[1]);
                taskList[tempNum].unmark();
                System.out.println(LINE);
                continue;
            }
            taskList[numOfTask] = new Task(tempString);
            numOfTask++;
            System.out.println(LINE + "added: " + tempString + "\n" + LINE);
        }
    }
}
