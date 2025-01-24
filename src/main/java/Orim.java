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
            String cmd = sc.next();
            System.out.println(LINE);
            switch (cmd) {
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!\n" + LINE);
                    System.exit(0);
                case "list":
                    System.out.println("\nHere are the tasks in your list:\n");
                    for (int i = 1; i < numOfTask; i++) {
                        Task curTask = taskList[i];
                        System.out.println(i + "." + curTask + "\n");
                    }
                    break;
                case "mark":
                    int markNum = sc.nextInt();
                    taskList[markNum].mark();
                    break;
                case "unmark":
                    int unmarkNum = sc.nextInt();
                    taskList[unmarkNum].unmark();
                    break;
                /*case "todo":
                    taskList
                    System*/
                default:
                    System.out.println(LINE);
            }

        }
    }
}
