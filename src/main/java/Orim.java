import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Orim {
    public static void main(String[] args) throws FileNotFoundException {
        String LINE = "____________________________________________________________\n";
        ArrayList<Task> taskList = new ArrayList<Task>();
        Scanner sc = new Scanner(System.in);

        // Load the past history or create an empty history
        File taskHistory = new File("src/main/data/history.txt");
        try {
            Scanner scf = new Scanner(taskHistory);
            while (scf.hasNext()) {
                String[] tempStrArr = scf.nextLine().split(",");
                switch (tempStrArr[0]) {
                case "T":
                    taskList.add(new Todo(tempStrArr[1], tempStrArr[2]));
                    break;
                case "D":
                    taskList.add(new Deadline(tempStrArr[1], tempStrArr[2], tempStrArr[3]));
                    break;
                case "E":
                    taskList.add(new Event(tempStrArr[1], tempStrArr[2], tempStrArr[3], tempStrArr[4]));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            try {
                taskHistory.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println(LINE + "Hello! I'm Orim.\n" + "What can I do for you?\n" + LINE);

        while (sc.hasNext()) {
            try {
                String cmd = sc.next();
                System.out.println(LINE);
                switch (cmd) {
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!\n" + LINE);

                    FileWriter fw = new FileWriter(taskHistory); //storing the history when exit the bot
                    String tempLog = "";
                    for (int i = 1; i < taskList.size() + 1; i++) {
                        tempLog = tempLog + taskList.get(i - 1).generateLog() + "\n";
                    }
                    fw.write(tempLog);
                    fw.close();
                    System.exit(0);
                case "list":
                    System.out.println("\nHere are the tasks in your list:\n");
                    for (int i = 1; i < taskList.size() + 1; i++) {
                        System.out.println(i + "." + taskList.get(i - 1) + "\n");
                    }
                    break;
                case "mark":
                    taskList.get(sc.nextInt() - 1).mark();
                    break;
                case "unmark":
                    taskList.get(sc.nextInt() - 1).unmark();
                    break;
                case "delete":
                    Task remTask = taskList.remove(sc.nextInt() - 1);
                    System.out.println("Noted. I've removed this task:\n " + remTask.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                case "todo":
                    String todoDes = sc.nextLine().trim();
                    if (todoDes.equals("")) {
                        throw new MissingContentException("", "todo");
                    }
                    Todo tempT = new Todo(todoDes);
                    taskList.add(tempT);
                    System.out.println("Got it. I've added this task:\n " + tempT.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                case "deadline":
                    String dStr = sc.nextLine();
                    if (dStr.equals("")) {
                        throw new MissingContentException("", "deadline");
                    }
                    Deadline tempD = new Deadline(dStr.split("/by")[0].trim(),
                            dStr.split("/by")[1].trim());
                    taskList.add(tempD);
                    System.out.println("Got it. I've added this task:\n " + tempD.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                case "event":
                    String eStr = sc.nextLine();
                    if (eStr.equals("")) {
                        throw new MissingContentException("", "event");
                    }
                    Event tempE = new Event(eStr.split("/from")[0].trim(),
                            eStr.split("/from")[1].split("/to")[0].trim(),
                            eStr.split("/from")[1].split("/to")[1].trim());
                    taskList.add(tempE);
                    System.out.println("Got it. I've added this task:\n " + tempE.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;
                default:
                    throw new IncorrectInputException("");
                }
            } catch (IncorrectInputException e) {
                System.out.println(" OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (MissingContentException e) {
                System.out.println(" OOPS!!! The description of a " + e + " cannot be empty.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(LINE);
        }


    }
}
