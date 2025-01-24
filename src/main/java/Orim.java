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
        String[] taskList = new String[101];
        int numOfTask = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello from\n" + logo);
        System.out.println(LINE + "Hello! I'm Orim.\n" + "What can I do for you?\n" + LINE);
        while (sc.hasNext()) {
            String temp = sc.nextLine();
            if (temp.equals("bye")) {
                System.out.println(LINE + "Bye. Hope to see you again soon!\n" + LINE);
                System.exit(0);
            }
            if (temp.equals("list")) {
                System.out.println(LINE);
                for (int i = 1; i < numOfTask; i++) {
                    System.out.println(i + ". " + taskList[i] + "\n");
                }
                System.out.println(LINE);
                continue;
            }
            taskList[numOfTask] = temp;
            numOfTask++;
            System.out.println(LINE + "added: " + temp + "\n" + LINE);
        }
    }
}
